import oasis.names.tc.xacml._3_0.core.schema.wd_17.DecisionType;
import org.ow2.authzforce.core.pdp.api.*;
import org.ow2.authzforce.core.pdp.api.value.*;
import org.ow2.authzforce.core.pdp.impl.BasePdpEngine;
import org.ow2.authzforce.core.pdp.impl.PdpEngineConfiguration;
import org.ow2.authzforce.xacml.identifiers.XacmlAttributeId;

import java.io.IOException;
import java.util.Optional;

import static org.ow2.authzforce.xacml.identifiers.XacmlAttributeCategory.*;


public class Souradip {
    public static void main(String[] args) throws IOException {
        // Create PDP engine configuration
        final PdpEngineConfiguration pdpEngineConf = PdpEngineConfiguration.getInstance("file:src/main/pdp.xml");

        /* Create the PDP engine. You can reuse the same for all requests, so do it only once for all.
        */
        final BasePdpEngine pdp = new BasePdpEngine(pdpEngineConf);

        // Create the XACML request in native model
        final DecisionRequestBuilder<?> requestBuilder = pdp.newRequestBuilder(-1, 1);

        // Add subject ID attribute (access-subject category), no issuer, string value "Julius Hibbert"
        final AttributeFqn subjectIdAttributeId =
                AttributeFqns.newInstance(
                        XACML_1_0_ACCESS_SUBJECT.value(),
                        Optional.empty(),
                        XacmlAttributeId.XACML_1_0_SUBJECT_ID.value());

        final AttributeBag<?> subjectIdAttributeValues =
                Bags.singletonAttributeBag(
                        StandardDatatypes.STRING,
                        new StringValue("Julius Hibbert"));

        requestBuilder.putNamedAttributeIfAbsent(subjectIdAttributeId, subjectIdAttributeValues);

        // Add subject role(s) attribute to access-subject category, no issuer, string value "boss"
//        final AttributeFqn subjectRoleAttributeId =
//                AttributeFqns.newInstance(
//                        XACML_1_0_ACCESS_SUBJECT.value(),
//                        Optional.empty(),
//                        XacmlAttributeId.XACML_2_0_SUBJECT_ROLE.value());
//
//        final AttributeBag<?> roleAttributeValues =
//                Bags.singletonAttributeBag(StandardDatatypes.STRING,
//                        new StringValue("boss"));
//
//        requestBuilder.putNamedAttributeIfAbsent(subjectRoleAttributeId, roleAttributeValues);

        // Add resource ID attribute (resource category), no issuer, string value "/some/resource/location"
        final AttributeFqn resourceIdAttributeId =
                AttributeFqns.newInstance(
                        XACML_3_0_RESOURCE.value(),
                        Optional.empty(),
                        XacmlAttributeId.XACML_1_0_RESOURCE_ID.value());

        final AttributeBag<?> resourceIdAttributeValues =
                Bags.singletonAttributeBag(
                        StandardDatatypes.ANYURI,
                        new AnyUriValue("http://medico.com/record/patient/BartSimpson"));

        requestBuilder.putNamedAttributeIfAbsent(resourceIdAttributeId, resourceIdAttributeValues);

        // Add action ID attribute (action category), no issuer, string value "GET"
        final AttributeFqn actionIdAttributeId =
                AttributeFqns.newInstance(
                        XACML_3_0_ACTION.value(),
                        Optional.empty(),
                        XacmlAttributeId.XACML_1_0_ACTION_ID.value());

        final AttributeBag<?> actionIdAttributeValues =
                Bags.singletonAttributeBag(
                        StandardDatatypes.STRING,
                        new StringValue("read"));
        requestBuilder.putNamedAttributeIfAbsent(actionIdAttributeId, actionIdAttributeValues);

        final DecisionRequest request = requestBuilder.build(false);
        System.out.println(request.getNamedAttributes());

        final DecisionResult result = pdp.evaluate(request);
        System.out.println(result);

        if(result.getDecision() == DecisionType.PERMIT) {
            // This is a Permit :-)
            System.out.println("This is a Permit!");
        } else {
            // Not a Permit :-( (maybe Deny, NotApplicable or Indeterminate
            System.out.println("This is maybe Deny, NA, or Indeterminate");
        }


    }
}

// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.fluent.models.MetadataPropertiesPatch;
import com.azure.resourcemanager.securityinsights.models.Kind;
import com.azure.resourcemanager.securityinsights.models.MetadataAuthor;
import com.azure.resourcemanager.securityinsights.models.MetadataCategories;
import com.azure.resourcemanager.securityinsights.models.MetadataDependencies;
import com.azure.resourcemanager.securityinsights.models.MetadataSource;
import com.azure.resourcemanager.securityinsights.models.MetadataSupport;
import com.azure.resourcemanager.securityinsights.models.Operator;
import com.azure.resourcemanager.securityinsights.models.SourceKind;
import com.azure.resourcemanager.securityinsights.models.SupportTier;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class MetadataPropertiesPatchTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MetadataPropertiesPatch model = BinaryData.fromString(
            "{\"contentId\":\"ri\",\"parentId\":\"rsrrmoucsofldp\",\"version\":\"iyfc\",\"kind\":\"Playbook\",\"source\":{\"kind\":\"Community\",\"name\":\"hbhlvbm\",\"sourceId\":\"qi\"},\"author\":{\"name\":\"tkcudfbsfarfsiow\",\"email\":\"jxnqp\",\"link\":\"gf\"},\"support\":{\"tier\":\"Microsoft\",\"name\":\"qyki\",\"email\":\"d\",\"link\":\"aoaf\"},\"dependencies\":{\"contentId\":\"qvoxmycj\",\"kind\":\"LogicAppsCustomConnector\",\"version\":\"vwg\",\"name\":\"wpbmzgwesydsxwef\",\"operator\":\"AND\",\"criteria\":[{\"contentId\":\"opwndyqleallk\",\"kind\":\"PlaybookTemplate\",\"version\":\"hlowkx\",\"name\":\"vbrdfjmzsyzfho\",\"operator\":\"AND\",\"criteria\":[{\"contentId\":\"yych\",\"kind\":\"DataType\",\"version\":\"lpjrtwsz\",\"name\":\"vuicp\",\"operator\":\"AND\",\"criteria\":[{}]}]},{\"contentId\":\"hwrbfdpyflubh\",\"kind\":\"WatchlistTemplate\",\"version\":\"r\",\"name\":\"uyzlw\",\"operator\":\"OR\",\"criteria\":[{\"contentId\":\"ooclutnp\",\"kind\":\"Workbook\",\"version\":\"czj\",\"name\":\"mykyujxsglhs\",\"operator\":\"AND\",\"criteria\":[{},{},{}]},{\"contentId\":\"ylmbkzudni\",\"kind\":\"LogicAppsCustomConnector\",\"version\":\"hotj\",\"name\":\"lpxuzzjgnrefq\",\"operator\":\"OR\",\"criteria\":[{},{},{}]}]},{\"contentId\":\"ihiqakydiw\",\"kind\":\"Watchlist\",\"version\":\"wpzdqtvhcspo\",\"name\":\"qaxsipietgbebjf\",\"operator\":\"AND\",\"criteria\":[{\"contentId\":\"chdlpnfpubn\",\"kind\":\"Playbook\",\"version\":\"tzviqsowsaaelcat\",\"name\":\"ju\",\"operator\":\"AND\",\"criteria\":[{},{},{}]},{\"contentId\":\"mjcwmjvlgfg\",\"kind\":\"WorkbookTemplate\",\"version\":\"yylizrz\",\"name\":\"psfxsf\",\"operator\":\"AND\",\"criteria\":[{},{}]},{\"contentId\":\"mvagbwidqlvhuko\",\"kind\":\"AnalyticsRule\",\"version\":\"i\",\"name\":\"vjfn\",\"operator\":\"AND\",\"criteria\":[{},{}]},{\"contentId\":\"yzgib\",\"kind\":\"PlaybookTemplate\",\"version\":\"rllfojuidjpuuyj\",\"name\":\"ejikzoeovvtzejet\",\"operator\":\"AND\",\"criteria\":[{},{}]}]}]},\"categories\":{\"domains\":[\"juzkdbqz\",\"lxrzvhqjwtr\"],\"verticals\":[\"vgzpcrrkolawj\"]},\"providers\":[\"mwrokcdxfzzzwyja\"],\"customVersion\":\"hguynuchlgmltxdw\",\"contentSchemaVersion\":\"ozusgz\",\"icon\":\"ns\",\"threatAnalysisTactics\":[\"zfpafolpymwamxqz\",\"agpgdph\",\"vdulajv\",\"ejchcsrlz\"],\"threatAnalysisTechniques\":[\"zlanrupdwvnph\",\"nzqtpjhmqrhvt\"],\"previewImages\":[\"iwdcxsmlzzhzd\",\"xetlgydlhqv\",\"n\",\"pxy\"],\"previewImagesDark\":[\"iqge\",\"arbgjekgl\"]}")
            .toObject(MetadataPropertiesPatch.class);
        Assertions.assertEquals("ri", model.contentId());
        Assertions.assertEquals("rsrrmoucsofldp", model.parentId());
        Assertions.assertEquals("iyfc", model.version());
        Assertions.assertEquals(Kind.PLAYBOOK, model.kind());
        Assertions.assertEquals(SourceKind.COMMUNITY, model.source().kind());
        Assertions.assertEquals("hbhlvbm", model.source().name());
        Assertions.assertEquals("qi", model.source().sourceId());
        Assertions.assertEquals("tkcudfbsfarfsiow", model.author().name());
        Assertions.assertEquals("jxnqp", model.author().email());
        Assertions.assertEquals("gf", model.author().link());
        Assertions.assertEquals(SupportTier.MICROSOFT, model.support().tier());
        Assertions.assertEquals("qyki", model.support().name());
        Assertions.assertEquals("d", model.support().email());
        Assertions.assertEquals("aoaf", model.support().link());
        Assertions.assertEquals("qvoxmycj", model.dependencies().contentId());
        Assertions.assertEquals(Kind.LOGIC_APPS_CUSTOM_CONNECTOR, model.dependencies().kind());
        Assertions.assertEquals("vwg", model.dependencies().version());
        Assertions.assertEquals("wpbmzgwesydsxwef", model.dependencies().name());
        Assertions.assertEquals(Operator.AND, model.dependencies().operator());
        Assertions.assertEquals("opwndyqleallk", model.dependencies().criteria().get(0).contentId());
        Assertions.assertEquals(Kind.PLAYBOOK_TEMPLATE, model.dependencies().criteria().get(0).kind());
        Assertions.assertEquals("hlowkx", model.dependencies().criteria().get(0).version());
        Assertions.assertEquals("vbrdfjmzsyzfho", model.dependencies().criteria().get(0).name());
        Assertions.assertEquals(Operator.AND, model.dependencies().criteria().get(0).operator());
        Assertions.assertEquals("yych", model.dependencies().criteria().get(0).criteria().get(0).contentId());
        Assertions.assertEquals(Kind.DATA_TYPE, model.dependencies().criteria().get(0).criteria().get(0).kind());
        Assertions.assertEquals("lpjrtwsz", model.dependencies().criteria().get(0).criteria().get(0).version());
        Assertions.assertEquals("vuicp", model.dependencies().criteria().get(0).criteria().get(0).name());
        Assertions.assertEquals(Operator.AND, model.dependencies().criteria().get(0).criteria().get(0).operator());
        Assertions.assertEquals("juzkdbqz", model.categories().domains().get(0));
        Assertions.assertEquals("vgzpcrrkolawj", model.categories().verticals().get(0));
        Assertions.assertEquals("mwrokcdxfzzzwyja", model.providers().get(0));
        Assertions.assertEquals("hguynuchlgmltxdw", model.customVersion());
        Assertions.assertEquals("ozusgz", model.contentSchemaVersion());
        Assertions.assertEquals("ns", model.icon());
        Assertions.assertEquals("zfpafolpymwamxqz", model.threatAnalysisTactics().get(0));
        Assertions.assertEquals("zlanrupdwvnph", model.threatAnalysisTechniques().get(0));
        Assertions.assertEquals("iwdcxsmlzzhzd", model.previewImages().get(0));
        Assertions.assertEquals("iqge", model.previewImagesDark().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MetadataPropertiesPatch model = new MetadataPropertiesPatch().withContentId("ri")
            .withParentId("rsrrmoucsofldp")
            .withVersion("iyfc")
            .withKind(Kind.PLAYBOOK)
            .withSource(new MetadataSource().withKind(SourceKind.COMMUNITY).withName("hbhlvbm").withSourceId("qi"))
            .withAuthor(new MetadataAuthor().withName("tkcudfbsfarfsiow").withEmail("jxnqp").withLink("gf"))
            .withSupport(
                new MetadataSupport().withTier(SupportTier.MICROSOFT).withName("qyki").withEmail("d").withLink("aoaf"))
            .withDependencies(new MetadataDependencies().withContentId("qvoxmycj")
                .withKind(Kind.LOGIC_APPS_CUSTOM_CONNECTOR)
                .withVersion("vwg")
                .withName("wpbmzgwesydsxwef")
                .withOperator(Operator.AND)
                .withCriteria(Arrays.asList(
                    new MetadataDependencies().withContentId("opwndyqleallk")
                        .withKind(Kind.PLAYBOOK_TEMPLATE)
                        .withVersion("hlowkx")
                        .withName("vbrdfjmzsyzfho")
                        .withOperator(Operator.AND)
                        .withCriteria(Arrays.asList(new MetadataDependencies().withContentId("yych")
                            .withKind(Kind.DATA_TYPE)
                            .withVersion("lpjrtwsz")
                            .withName("vuicp")
                            .withOperator(Operator.AND)
                            .withCriteria(Arrays.asList(new MetadataDependencies())))),
                    new MetadataDependencies().withContentId("hwrbfdpyflubh")
                        .withKind(Kind.WATCHLIST_TEMPLATE)
                        .withVersion("r")
                        .withName("uyzlw")
                        .withOperator(Operator.OR)
                        .withCriteria(Arrays.asList(
                            new MetadataDependencies().withContentId("ooclutnp")
                                .withKind(Kind.WORKBOOK)
                                .withVersion("czj")
                                .withName("mykyujxsglhs")
                                .withOperator(Operator.AND)
                                .withCriteria(Arrays.asList(new MetadataDependencies(), new MetadataDependencies(),
                                    new MetadataDependencies())),
                            new MetadataDependencies().withContentId("ylmbkzudni")
                                .withKind(Kind.LOGIC_APPS_CUSTOM_CONNECTOR)
                                .withVersion("hotj")
                                .withName("lpxuzzjgnrefq")
                                .withOperator(Operator.OR)
                                .withCriteria(Arrays.asList(new MetadataDependencies(), new MetadataDependencies(),
                                    new MetadataDependencies())))),
                    new MetadataDependencies().withContentId("ihiqakydiw")
                        .withKind(Kind.WATCHLIST)
                        .withVersion("wpzdqtvhcspo")
                        .withName("qaxsipietgbebjf")
                        .withOperator(Operator.AND)
                        .withCriteria(Arrays.asList(
                            new MetadataDependencies().withContentId("chdlpnfpubn")
                                .withKind(Kind.PLAYBOOK)
                                .withVersion("tzviqsowsaaelcat")
                                .withName("ju")
                                .withOperator(Operator.AND)
                                .withCriteria(Arrays.asList(new MetadataDependencies(), new MetadataDependencies(),
                                    new MetadataDependencies())),
                            new MetadataDependencies().withContentId("mjcwmjvlgfg")
                                .withKind(Kind.WORKBOOK_TEMPLATE)
                                .withVersion("yylizrz")
                                .withName("psfxsf")
                                .withOperator(Operator.AND)
                                .withCriteria(Arrays.asList(new MetadataDependencies(), new MetadataDependencies())),
                            new MetadataDependencies().withContentId("mvagbwidqlvhuko")
                                .withKind(Kind.ANALYTICS_RULE)
                                .withVersion("i")
                                .withName("vjfn")
                                .withOperator(Operator.AND)
                                .withCriteria(Arrays.asList(new MetadataDependencies(), new MetadataDependencies())),
                            new MetadataDependencies().withContentId("yzgib")
                                .withKind(Kind.PLAYBOOK_TEMPLATE)
                                .withVersion("rllfojuidjpuuyj")
                                .withName("ejikzoeovvtzejet")
                                .withOperator(Operator.AND)
                                .withCriteria(
                                    Arrays.asList(new MetadataDependencies(), new MetadataDependencies())))))))
            .withCategories(new MetadataCategories().withDomains(Arrays.asList("juzkdbqz", "lxrzvhqjwtr"))
                .withVerticals(Arrays.asList("vgzpcrrkolawj")))
            .withProviders(Arrays.asList("mwrokcdxfzzzwyja"))
            .withCustomVersion("hguynuchlgmltxdw")
            .withContentSchemaVersion("ozusgz")
            .withIcon("ns")
            .withThreatAnalysisTactics(Arrays.asList("zfpafolpymwamxqz", "agpgdph", "vdulajv", "ejchcsrlz"))
            .withThreatAnalysisTechniques(Arrays.asList("zlanrupdwvnph", "nzqtpjhmqrhvt"))
            .withPreviewImages(Arrays.asList("iwdcxsmlzzhzd", "xetlgydlhqv", "n", "pxy"))
            .withPreviewImagesDark(Arrays.asList("iqge", "arbgjekgl"));
        model = BinaryData.fromObject(model).toObject(MetadataPropertiesPatch.class);
        Assertions.assertEquals("ri", model.contentId());
        Assertions.assertEquals("rsrrmoucsofldp", model.parentId());
        Assertions.assertEquals("iyfc", model.version());
        Assertions.assertEquals(Kind.PLAYBOOK, model.kind());
        Assertions.assertEquals(SourceKind.COMMUNITY, model.source().kind());
        Assertions.assertEquals("hbhlvbm", model.source().name());
        Assertions.assertEquals("qi", model.source().sourceId());
        Assertions.assertEquals("tkcudfbsfarfsiow", model.author().name());
        Assertions.assertEquals("jxnqp", model.author().email());
        Assertions.assertEquals("gf", model.author().link());
        Assertions.assertEquals(SupportTier.MICROSOFT, model.support().tier());
        Assertions.assertEquals("qyki", model.support().name());
        Assertions.assertEquals("d", model.support().email());
        Assertions.assertEquals("aoaf", model.support().link());
        Assertions.assertEquals("qvoxmycj", model.dependencies().contentId());
        Assertions.assertEquals(Kind.LOGIC_APPS_CUSTOM_CONNECTOR, model.dependencies().kind());
        Assertions.assertEquals("vwg", model.dependencies().version());
        Assertions.assertEquals("wpbmzgwesydsxwef", model.dependencies().name());
        Assertions.assertEquals(Operator.AND, model.dependencies().operator());
        Assertions.assertEquals("opwndyqleallk", model.dependencies().criteria().get(0).contentId());
        Assertions.assertEquals(Kind.PLAYBOOK_TEMPLATE, model.dependencies().criteria().get(0).kind());
        Assertions.assertEquals("hlowkx", model.dependencies().criteria().get(0).version());
        Assertions.assertEquals("vbrdfjmzsyzfho", model.dependencies().criteria().get(0).name());
        Assertions.assertEquals(Operator.AND, model.dependencies().criteria().get(0).operator());
        Assertions.assertEquals("yych", model.dependencies().criteria().get(0).criteria().get(0).contentId());
        Assertions.assertEquals(Kind.DATA_TYPE, model.dependencies().criteria().get(0).criteria().get(0).kind());
        Assertions.assertEquals("lpjrtwsz", model.dependencies().criteria().get(0).criteria().get(0).version());
        Assertions.assertEquals("vuicp", model.dependencies().criteria().get(0).criteria().get(0).name());
        Assertions.assertEquals(Operator.AND, model.dependencies().criteria().get(0).criteria().get(0).operator());
        Assertions.assertEquals("juzkdbqz", model.categories().domains().get(0));
        Assertions.assertEquals("vgzpcrrkolawj", model.categories().verticals().get(0));
        Assertions.assertEquals("mwrokcdxfzzzwyja", model.providers().get(0));
        Assertions.assertEquals("hguynuchlgmltxdw", model.customVersion());
        Assertions.assertEquals("ozusgz", model.contentSchemaVersion());
        Assertions.assertEquals("ns", model.icon());
        Assertions.assertEquals("zfpafolpymwamxqz", model.threatAnalysisTactics().get(0));
        Assertions.assertEquals("zlanrupdwvnph", model.threatAnalysisTechniques().get(0));
        Assertions.assertEquals("iwdcxsmlzzhzd", model.previewImages().get(0));
        Assertions.assertEquals("iqge", model.previewImagesDark().get(0));
    }
}

// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tosstudio.importexport;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ExportJobTest extends TalendSwtBotForTos {

    private SWTBotTree tree;

    private SWTBotView view;

    private SWTBotTreeItem treeNode;

    private static final String JOBNAME = "test01"; //$NON-NLS-1$

    private static final String SAMPLE_RELATIVE_FILEPATH = "items.zip"; //$NON-NLS-1$

    private static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator"); // $NON-NLS-1$

    private static boolean isExportAsZipFile = false;

    @Before
    public void createAJob() {
        view = Utilities.getRepositoryView(gefBot);
        view.setFocus();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        treeNode = Utilities.getTalendItemNode(tree, Utilities.TalendItemType.JOB_DESIGNS);
        Utilities.createJob(JOBNAME, treeNode, gefBot);
    }

    @Test
    public void exportJob() throws IOException, URISyntaxException {
        tree.expandNode("Job Designs").getNode(JOBNAME + " 0.1").contextMenu("Export Job").click();
        gefBot.shell("Export Job").activate();
        gefBot.comboBoxWithLabel("To &archive file:").setText(
                Utilities.getFileFromCurrentPluginSampleFolder(SAMPLE_RELATIVE_FILEPATH).getParent() + FILE_SEPARATOR
                        + "output_job.zip");
        gefBot.button("Finish").click();
        gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 60000);

        isExportAsZipFile = Utilities.getFileFromCurrentPluginSampleFolder("output_job.zip").exists();
        Assert.assertEquals(true, isExportAsZipFile);
    }

    @After
    public void removePreviouslyCreateItems() throws IOException, URISyntaxException {
        Utilities.getFileFromCurrentPluginSampleFolder("output_job.zip").delete();
        gefBot.cTabItem("Job " + JOBNAME + " 0.1").close();
        Utilities.delete(tree, treeNode, JOBNAME, "0.1", null);
        Utilities.emptyRecycleBin(gefBot, tree);
    }
}
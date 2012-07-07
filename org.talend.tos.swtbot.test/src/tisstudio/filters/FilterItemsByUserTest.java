// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tisstudio.filters;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotViewMenu;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarButton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class FilterItemsByUserTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private SWTBotViewMenu menu;

    private SWTBotToolbarButton button;

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem("job_a");
        jobItem.create();
    }

    @Test
    public void filterItemsByUser() {
        int rowCount = 0;

        button = gefBot.viewByTitle("Repository").toolbarButton("Activte Filter \n(filter settings available in the view menu)");
        button.click();
        menu = gefBot.viewByTitle("Repository").menu("Filter Setting...");
        menu.click();

        gefBot.shell("Repository Filter Setting").activate();
        gefBot.checkBox("All Users").click();
        gefBot.table(0).getTableItem(0).uncheck();
        gefBot.button("OK").click();

        rowCount = jobItem.getParentNode().rowCount();

        Assert.assertEquals("items did not filter", 0, rowCount);
    }

    @After
    public void removePreviouslyCreateItems() {
        menu.click();
        gefBot.checkBox("All Users").click();
        gefBot.button("OK").click();
        button.click();
    }
}

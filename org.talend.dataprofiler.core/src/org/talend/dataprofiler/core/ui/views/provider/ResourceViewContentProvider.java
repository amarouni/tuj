// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataprofiler.core.ui.views.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.talend.dataprofiler.core.manager.DQStructureManager;
import org.talend.dataprofiler.core.ui.utils.ComparatorsFactory;

/**
 * DOC rli class global comment. Detailled comment
 */
public class ResourceViewContentProvider extends WorkbenchContentProvider {

    private static Logger log = Logger.getLogger(ResourceViewContentProvider.class);

    private List<IContainer> needSortContainers;

    /**
     * DOC rli ResourceViewContentProvider constructor comment.
     */
    public ResourceViewContentProvider() {
        super();
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        needSortContainers = new ArrayList<IContainer>();
        needSortContainers.add(root.getProject(DQStructureManager.DATA_PROFILING).getFolder(DQStructureManager.ANALYSIS));
        needSortContainers.add(root.getProject(DQStructureManager.DATA_PROFILING).getFolder(DQStructureManager.REPORTS));
        needSortContainers.add(root.getProject(DQStructureManager.METADATA).getFolder(DQStructureManager.DB_CONNECTIONS));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.internal.navigator.resources.workbench.ResourceExtensionContentProvider#getChildren(java.lang.Object)
     */
    @Override
    public Object[] getChildren(Object element) {
        if (needSortContainers.contains(element)) {
            return sort(super.getChildren(element));
        }
        return super.getChildren(element);
    }

    /**
     * Sort the parameter objects, and return the sorted array.
     * 
     * @param elements
     * @return
     */
    @SuppressWarnings("unchecked")
    protected Object[] sort(Object[] elements) {
        if (elements == null) {
            return elements;
        }
        List<IFile> list = new ArrayList<IFile>();
        for (Object element : elements) {
            if (element instanceof IFile) {
                list.add((IFile) element);
            } else {
                log.error("The elemnt:" + ((IFolder) element).getFullPath() + " can't display on the workspace!");
            }
        }

        Collections.sort(list, ComparatorsFactory.buildComparator(ComparatorsFactory.FILEMODEL_COMPARATOR_ID));
        return list.toArray();
    }

}

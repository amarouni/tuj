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
package org.talend.rcp.branding.talendplatform.cloud;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;
import org.talend.core.tis.branding.TdqBrandingConfiguration;
import org.talend.core.ui.branding.AbstractTalendBrandingService;
import org.talend.core.ui.branding.IBrandingConfiguration;

/**
 * DOC smallet class global comment. Detailled comment <br/>
 * 
 */
public class CloudBrandingService extends AbstractTalendBrandingService {

    protected IBrandingConfiguration brandingConfigure;

    public String getShortProductName() {
        return getProductName();
    }

    public String getCorporationName() {
        return "Talend";
    }

    public ImageDescriptor getLoginVImage() {
        return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/login_v.jpg"); //$NON-NLS-1$
    }

    public ImageDescriptor getLoginHImage() {
        return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/login_h.jpg"); //$NON-NLS-1$
    }

    public URL getLicenseFile() throws IOException {
        final Bundle b = Platform.getBundle(Activator.PLUGIN_ID);
        final URL url = FileLocator.toFileURL(FileLocator.find(b, new Path("resources/license.txt"), null)); //$NON-NLS-1$
        return url;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingService#getBrandingConfiguration()
     */
    public IBrandingConfiguration getBrandingConfiguration() {
        if (brandingConfigure == null) {
            brandingConfigure = new TdqBrandingConfiguration();
        }
        return brandingConfigure;
    }

    public String getAcronym() {
        return "tdq";
    }

    public String getProductName() {
        return "Talend Platform";
    }

    public String getOptionName() {
        return "for Cloud";
    }
}
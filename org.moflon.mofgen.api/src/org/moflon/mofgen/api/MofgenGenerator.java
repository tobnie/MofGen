package org.moflon.mofgen.api;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * This abstract class provides a superclass for all generator blocks specified in mofgen-files.
 * @author Tobias Niehues
 *
 */
public abstract class MofgenGenerator {

	protected String name;
	
	/**
	 * This method runs the specified generator.
	 * @return the eobject to save as resource
	 */
	public abstract EObject start();
	
	public void startAndSave(String path, String fileName) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
	
		URI uri = URI.createFileURI(path+"\\"+fileName+".xmi");
		Resource modelResource = rs.createResource(uri);
		modelResource.getContents().add(start());
	
		Map<Object, Object> saveOptions = ((XMIResource) modelResource).getDefaultSaveOptions();
		saveOptions.put(XMIResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
	
		try {
			((XMIResource) modelResource).save(saveOptions);
		} catch (IOException e) {
			System.out.println("Saving resource failed with "+e.getMessage()+"\n"+e.getStackTrace());
		}
		modelResource.unload();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return this.getName();
	}
	
}

package com.iaihome.content;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * @author Tiamo
 */

@Component(
	    property = { "language.id=zh_CN" }, 
	    service = ResourceBundle.class
	)

public class zhCNResourceBundle extends ResourceBundle {
    @Override
    protected Object handleGetObject(String key) {
        return _resourceBundle.getObject(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return _resourceBundle.getKeys();
    }

    private final ResourceBundle _resourceBundle = ResourceBundle.getBundle(
        "content.Language", UTF8Control.INSTANCE);
}
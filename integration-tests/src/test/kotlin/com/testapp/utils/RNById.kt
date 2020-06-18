package com.testapp.utils

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebElement

internal class ByRnId(val driver: AppiumDriver<*>, val id: String) : By() {

    override fun findElements(context: SearchContext): List<WebElement> {
        when(driver.capabilities.getCapability("platform")){
            "ios" -> return context.findElements(name(id))
            else -> return context.findElements(MobileBy.ByAccessibilityId(id))
        }
    }

    override fun findElement(context: SearchContext): WebElement {
        when(driver.capabilities.getCapability("platform")){
            "ios" -> return context.findElement(name(id))
            else -> return context.findElement(MobileBy.ByAccessibilityId(id))
        }
    }

    override fun toString(): String {
        return "ByRnId: $id"
    }
}
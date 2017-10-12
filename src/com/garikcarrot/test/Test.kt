package com.garikcarrot.test

import org.lwjgl.opengl.XRandR
import java.awt.Toolkit

/**
 * Created by garik-carrot on 13.10.17.
 */
fun main(args: Array<String>) {
    XRandR.getConfiguration().forEach { s -> println(s) }
    XRandR.getScreenNames().forEach { s -> println(s) }
    XRandR.getScreenNames().forEach { s ->
        XRandR.getResolutions(s).forEach { t -> println(t) }
    }
}
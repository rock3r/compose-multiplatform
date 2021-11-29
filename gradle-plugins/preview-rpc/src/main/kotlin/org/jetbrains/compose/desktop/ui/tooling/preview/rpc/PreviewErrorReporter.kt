/*
 * Copyright 2020-2021 JetBrains s.r.o. and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

package org.jetbrains.compose.desktop.ui.tooling.preview.rpc

interface PreviewErrorReporter {
    fun report(e: Throwable, details: String? = null)
    fun report(e: String, details: String? = null)
}

object StderrPreviewErrorReporter : PreviewErrorReporter {
    override fun report(e: Throwable, details: String?) {
        report(e.stackTraceString)
    }

    override fun report(e: String, details: String?) {
        System.err.println(e)
    }
}
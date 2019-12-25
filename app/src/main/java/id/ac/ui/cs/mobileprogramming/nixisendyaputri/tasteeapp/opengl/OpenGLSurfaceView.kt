package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.opengl

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet

class OpenGLSurfaceView(context: Context, attrs: AttributeSet) : GLSurfaceView(context, attrs) {

    private val renderer: OpenGLRenderer

    init {

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2)

        renderer = OpenGLRenderer(context)

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer)
    }
}
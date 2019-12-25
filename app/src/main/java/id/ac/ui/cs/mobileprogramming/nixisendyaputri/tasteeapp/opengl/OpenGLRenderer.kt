package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.opengl

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLES20.*
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import android.os.SystemClock
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class OpenGLRenderer(val context: Context) : GLSurfaceView.Renderer {

    private lateinit var mSquare1: Square
    private lateinit var mSquare2: Square
    private lateinit var mSquare3: Square
    private val mViewMatrix = FloatArray(16)
    private val mMVPMatrix = FloatArray(16)
    private val mProjectionMatrix = FloatArray(16)
    private val mRotationMatrix = FloatArray(16)
    private var mTempMatrix = FloatArray(16)
    private val mModelMatrix = FloatArray(16)
    private var dx = 0f

    override fun onSurfaceCreated(unused: GL10, config: EGLConfig) {
        glClearColor(1.0f, 0.76078431372f, 0.23137254902f, 1.0f)

        val squareCoords = floatArrayOf(
            0.0f, 0.3f, 0.0f,      // top left
            -0.3f, 0f, 0.0f,      // bottom left
            0f, 0f, 0.0f,      // bottom right
            0.0f, 0f, 0.0f       // top right
        )
        val color = floatArrayOf(1.0f, 0.56862745098f, 0.1725490196f, 1.0f)

        mSquare1 = Square(squareCoords, color)
        mSquare2 = Square(squareCoords, color)
        mSquare3 = Square(squareCoords, color)
    }

    override fun onDrawFrame(unused: GL10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)

        rotateSquare(mSquare1, -1)
        rotateSquare(mSquare2, 1)
        rotateSquare(mSquare3, 0)
    }

    override fun onSurfaceChanged(unused: GL10, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
        val ratio = width.toFloat() / height

        // this projection matrix is applied to object coordinates
        // in the onDrawFrame() method
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1f, 1f, 3f, 7f)
    }

    private fun rotateSquare(square: Square, direction: Int) {
        Matrix.setIdentityM(mModelMatrix, 0) // initialize to identity matrix
        Matrix.translateM(mModelMatrix, 0, direction * dx, 0f, 0f) // translation to the left
        dx += 0.00000694f

        // Set the camera position (View matrix)
        Matrix.setLookAtM(mViewMatrix, 0, 0f, 0f, -3f, 0f, 0f, 0f, 0f, 1.0f, 0.0f)

        // Calculate the projection and view transformation
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0)

        // Create a rotation transformation for the square
        val time = SystemClock.uptimeMillis() % 8000L
        val angle = direction * 0.090f * time.toInt()
        Matrix.setRotateM(mRotationMatrix, 0, angle, 0f, 0f, -1.0f)

        mTempMatrix = mModelMatrix.clone()
        Matrix.multiplyMM(mModelMatrix, 0, mTempMatrix, 0, mRotationMatrix, 0)
        mTempMatrix = mMVPMatrix.clone()
        Matrix.multiplyMM(mMVPMatrix, 0, mTempMatrix, 0, mModelMatrix, 0)
        square.draw(mMVPMatrix)

    }

}
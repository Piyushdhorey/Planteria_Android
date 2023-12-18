package com.example.planteria.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.example.planteria.R
import com.example.planteria.activity.HomeActivity
import com.example.planteria.databinding.FragmentCaptureBinding
import com.google.android.material.snackbar.Snackbar
import com.google.common.util.concurrent.ListenableFuture

class CaptureFragment : Fragment() {

    lateinit var binding: FragmentCaptureBinding
    lateinit var homeActivity: HomeActivity
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private lateinit var cameraSelector: CameraSelector

    private val cameraProviderResult = registerForActivityResult(ActivityResultContracts.RequestPermission()){ permissionGranted->
        if(permissionGranted){
            // cut and paste the previous startCamera() call here.
            startCamera()
        }else {
            Snackbar.make(binding.root,"The camera permission is required", Snackbar.LENGTH_INDEFINITE).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCaptureBinding.inflate(layoutInflater, container, false)


        cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

        cameraProviderResult.launch(android.Manifest.permission.CAMERA)


        return binding.root
    }

    private fun startCamera(){
        // listening for data from the camera
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()

            // connecting a preview use case to the preview in the xml file.
            val preview = Preview.Builder().build().also{
                it.setSurfaceProvider(binding.preview.surfaceProvider)
            }
            try{
                // clear all the previous use cases first.
                cameraProvider.unbindAll()
                // binding the lifecycle of the camera to the lifecycle of the application.
                cameraProvider.bindToLifecycle(this,cameraSelector,preview)
            } catch (e: Exception) {
                Log.d(TAG, "Use case binding failed")
            }

        }, ContextCompat.getMainExecutor(requireContext()))
    }

    companion object {

        fun newInstance() =
            CaptureFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
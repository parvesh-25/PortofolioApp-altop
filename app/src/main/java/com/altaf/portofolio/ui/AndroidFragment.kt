package com.altaf.portofolio.ui


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.altaf.portofolio.portofolio_modul.PortofolioData
import com.altaf.portofolio.adapter.RVAndroidAdapter
import com.altaf.portofolio.R
import com.altaf.portofolio.databinding.FragmentAndroidBinding


private const val GITHUB_LINK = "https://github.com/salim-maula"

class AndroidFragment : Fragment() {

    private var _binding: FragmentAndroidBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAndroidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val androidadapter = RVAndroidAdapter()

        androidadapter.setData(PortofolioData.listAppAndroid)

        androidadapter.onItemClicked = { selectedData ->
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(selectedData.link))
        }
        with(binding.rvAndroid){
           layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = androidadapter
        }

        binding.btnAndroid.text = getString(
            R.string.app_android_btn,
            PortofolioData.listAppAndroid.size.toString()
        )

        binding.txtDokumentasi.setOnClickListener {
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(GITHUB_LINK))
        }


    }
}
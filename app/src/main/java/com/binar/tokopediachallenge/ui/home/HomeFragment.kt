package com.binar.tokopediachallenge.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.NestedScrollView
import com.binar.tokopediachallenge.R
import com.binar.tokopediachallenge.databinding.FragmentHomeBinding
import com.sopian.gojek.hide
import com.sopian.gojek.show
import com.sopian.gojek.util.enableStatusBar
import com.sopian.gojek.util.getColor

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeScrollview.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->

                if (scrollY > 150) {

                    changeStatusBarColorOnScrolled(R.color.white, true)

                    binding.toolbarBottomColor.show()

                    binding.editTextSearch.background =
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.edit_text_rounded_outline,
                            null
                        )
                    binding.imgInbox.setImageResource(R.drawable.ic_outline_email_black_24)
                    binding.imgNotif.setImageResource(R.drawable.ic_outline_notifications_black_24)
                    binding.imgCart.setImageResource(R.drawable.ic_outline_shopping_cart_black_24)
                    binding.imgDehaze.setImageResource(R.drawable.ic_outline_dehaze_black_24)

                } else if (oldScrollY > scrollY) {
                    binding.toolbarBottomColor.hide()

                    changeStatusBarColorOnScrolled(R.color.green, false)

                    binding.editTextSearch.background =
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.edit_text_rounded,
                            null
                        )
                    binding.imgInbox.setImageResource(R.drawable.ic_outline_email_24)
                    binding.imgNotif.setImageResource(R.drawable.ic_outline_notifications_24)
                    binding.imgCart.setImageResource(R.drawable.ic_outline_shopping_cart_24)
                    binding.imgDehaze.setImageResource(R.drawable.ic_outline_dehaze_24)
                }
            }
        )

        return binding.root
    }

    private fun changeStatusBarColorOnScrolled(color: Int, isScrollDown: Boolean) {
        val window = (activity as AppCompatActivity).window

        view?.let {
            if (isScrollDown) {
                enableStatusBar(true, it, window)
                binding.appbar.setBackgroundColor(
                    getColor(requireContext(), R.color.white)
                )
            } else {
                enableStatusBar(false, it, window)
                binding.appbar.setBackgroundColor(
                    getColor(requireContext(), R.color.green)
                )
            }
        }

        window.statusBarColor = getColor(requireContext(), color)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
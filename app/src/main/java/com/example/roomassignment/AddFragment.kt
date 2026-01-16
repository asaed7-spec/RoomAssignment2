package com.example.roomassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.roomassignment.databinding.FragmentAddBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        binding.addBtn.setOnClickListener {
            val name = binding.addCourseName.text.toString()
            val code = binding.addCourseCode.text.toString()

            if (name.isNotEmpty() && code.isNotEmpty()) {
                val course = Course(0, name, code)
                CoroutineScope(Dispatchers.IO).launch {
                    AppDatabase.getDatabase(requireContext()).myDao().addCourse(course)
                }
                Toast.makeText(requireContext(), "تمت الإضافة بنجاح", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_listFragment_to_addFragment) // العودة للقائمة
            }
        }
        return binding.root
    }
}
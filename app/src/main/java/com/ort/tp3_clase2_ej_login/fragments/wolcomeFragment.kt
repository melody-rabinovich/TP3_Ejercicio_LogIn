package com.ort.tp3_clase2_ej_login.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.ort.tp3_clase2_ej_login.R

class wolcomeFragment : Fragment() {



    lateinit var v : View;

    lateinit var btnBack : Button;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_wolcome, container, false);

        btnBack = v.findViewById(R.id.btnWolcome_Back);
        return v;
    }

    override fun onStart() {
        super.onStart()

        btnBack.setOnClickListener {
            findNavController().navigateUp();
        }
    }



}
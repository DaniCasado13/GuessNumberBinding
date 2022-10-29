package com.danicc.guessnumberfragment.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.danicc.guessnumberfragment.R;
import com.danicc.guessnumberfragment.databinding.FragmentEndPlayBinding;
/**
 * clase que responde segun si se ha superado el juego o no mediante el dato recibido en el bundle
 *<p>
 * si el booleano recibido es true: se informa de que se ha ganado el juego y el numero
 * de intentos necesarios.
 *<p>
 * si el booleano recibido es false: se informa de que se ha perdido y se muestra el numero oculto.
 * @author Dani Casado
 *  * @version 1.0
 */

public class EndPlayFragment extends Fragment {
    FragmentEndPlayBinding binding;
    boolean win = false;
    int intentos;
    int numero;
    String jugador;

    public EndPlayFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentEndPlayBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        savedInstanceState = getArguments();
        win = savedInstanceState.getBoolean("acertado");
        jugador = savedInstanceState.getString("jugador");
        numero = savedInstanceState.getInt("random");
        intentos = savedInstanceState.getInt("intentos");
        if (win) {
            binding.tvFinalMessage.setText(jugador + " " + getString(R.string.ganado) + " " + String.valueOf(intentos) + " " + getString(R.string.intentos));
        } else {
            binding.tvFinalMessage.setText(jugador + " " + getString(R.string.perdido) + numero);
        }
        binding.btnVolver.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_EndPlayFragment_to_ConfigFragment);
        });
    }
}
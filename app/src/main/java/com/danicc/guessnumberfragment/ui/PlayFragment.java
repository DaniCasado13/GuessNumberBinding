package com.danicc.guessnumberfragment.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.danicc.guessnumberfragment.R;
import com.danicc.guessnumberfragment.data.Juego;
import com.danicc.guessnumberfragment.databinding.FragmentPlayBinding;

import java.util.Random;

/**
 * Clase  que recibe el nombre del usuario y el numero de intentos que utilizara para jugar en un
 * objeto de la clase juego(nombre,numeroIntentos) enviada por el config fragment
 * <p>
 * Al pulsar sobre el boton probar se comprobara si el numero introducido es mayor menor o igual
 * que el creado como random en esta clase y se actuara segun el caso.
 * <p>
 * al pulsar sobre el boton borrar se dejara vacio el campo para introducir un numero
 * <p>
 * finalmente se envia a traves de un bundle si se ha acertado o no, el numero de intentos
 * gastados y el numero aleatorio a adivinar.
 *
 * @author Dani Casado
 * @version 1.0
 */
public class PlayFragment extends Fragment {
    FragmentPlayBinding binding;
    Random rnd = new Random();
    int rndint = rnd.nextInt(100) + 1;
    Juego juego;
    int maxIntentos;
    String nombreJugador;
    boolean acertado = false;
    int gastados = 0;

    public PlayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentPlayBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        juego = (Juego) getArguments().getSerializable("juego");

        maxIntentos = juego.getNumeroIntentos();
        nombreJugador = juego.getNombre();
        binding.btnProbar.setOnClickListener(v -> {
            ProbarNumero();
        });
        binding.btnBorrar.setOnClickListener(v -> {
            BorrarCampos();
        });
    }
    //metodo encargado de borrar los editext
    private void BorrarCampos() {
        binding.etNumeroIntentado.setText("");
        binding.tvInfo.setText("_");
    }

    //metodo para comprobar si el numero es correcto/menor/mayor
    private void ProbarNumero() {
        if (!ComprobarCampoVacio()) {
            if (ComprobarDigito()) {
                int numero = Integer.parseInt(binding.etNumeroIntentado.getText().toString());
                if (numero == rndint) {
                    acertado = true;
                    CargarEndPlay();
                    return;
                } else {
                    gastados++;
                    if (gastados == maxIntentos) {
                        CargarEndPlay();
                        return;
                    }
                    if (numero < rndint) {
                        binding.tvInfo.setText(nombreJugador + " " + getString(R.string.msgMayor));
                    } else {
                        binding.tvInfo.setText(nombreJugador + " " + getString(R.string.msgMenor));
                    }
                }
            } else {
                Toast.makeText(getContext(), R.string.ErrorType, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getContext(), R.string.ErrorEmpty, Toast.LENGTH_LONG).show();
        }
    }

    private void CargarEndPlay() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("acertado", acertado);
        bundle.putInt("intentos", gastados);
        bundle.putInt("random", rndint);
        bundle.putString("jugador", nombreJugador);
        NavHostFragment.findNavController(this).navigate(R.id.action_PlayFragment_to_EndPlayFragment, bundle);
    }

    private boolean ComprobarDigito() {
        return (TextUtils.isDigitsOnly(binding.etNumeroIntentado.getText()));
    }

    private boolean ComprobarCampoVacio() {
        return TextUtils.isEmpty(binding.etNumeroIntentado.getText());
    }
}
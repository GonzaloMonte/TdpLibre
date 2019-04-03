using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class JuegoSolo : juego
{
    public Text MaximoRecord;
    public DatosArchivo datos;


    // Start is called before the first frame update
    void Start()
    {
        puntacion.text = "0 - 0";
        puntaje1 = 0;
        puntaje2 = 0;
        datos = new DatosArchivo();
    }

    // Update is called once per frame
    void Update()
    {
        puntacion.text = puntaje1.ToString() + " - " + puntaje2.ToString();
        if (puntaje1 == puntajeMaximo)
        {
            ganador.text = "Gano player 1";
            activar();
            if (puntaje2 < datos.getPong())
            {
                datos.setPong(puntaje2);
            }
            MaximoRecord.text = "Maxima Goleada= "+ puntaje1.ToString() + " - " + datos.getPong();
            MaximoRecord.gameObject.SetActive(true);
        }
        if (puntaje2 == puntajeMaximo)
        {
            ganador.text = "Gano player 2";
            activar();
        }
    }
}

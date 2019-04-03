using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class player1 : MonoBehaviour
{
    public KeyCode arriba;
    public KeyCode abajo;

   
    float velocidad;
    float velocidadFinal;

    void Start()
    {
        velocidad=0.3f;
        
    }

  
    void Update()
    {
        if (Input.GetKey(arriba))
        {
            if (transform.localPosition.y > 4)
            {
                velocidadFinal = 0;
            }
            else velocidadFinal = velocidad;

         transform.Translate(0, velocidadFinal, 0);

        }
        if (Input.GetKey(abajo))
        {
            if (transform.localPosition.y < -4)
            {
                velocidadFinal = 0;
            }
            else velocidadFinal = velocidad;

            transform.Translate(0,-velocidadFinal, 0);

        }
    }
}

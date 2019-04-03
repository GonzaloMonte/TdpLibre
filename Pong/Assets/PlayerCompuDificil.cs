using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerCompuDificil : PlayerCompu
{

    
    void Start()
    {
        velocidad = 0.07f;
        velocidadFinal = 0.1f;
    }

   
    void Update()
    {   
        
            if (pelota.gameObject.transform.localPosition.y > transform.localPosition.y)
            {
                if (transform.localPosition.y > 4)
                {
                    velocidadFinal = 0;
                }
                else
                {
                    velocidadFinal = velocidad;
                }
            transform.Translate(0, velocidadFinal, 0);
            }

            if (pelota.gameObject.transform.localPosition.y < transform.localPosition.y)
            {
                if (transform.localPosition.y < -4)
                {
                    velocidadFinal = 0;
                }
                else
                {
                    velocidadFinal = velocidad;
                }
            transform.Translate(0, -velocidadFinal, 0);
               
            }
            
    }
    

  
}

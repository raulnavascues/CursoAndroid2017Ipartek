package com.example.arrow.app01peliculas;

import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ARROW on 21/03/2017.
 */

public class DatosPeliculas {
    public static final ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

    static {

        peliculas.add(new Pelicula(11,"1898 Los ultimos de Filipinas", "2016",  "España",180,"Salvador Calvo",
                "A finales del siglo XIX, en la colonia española de Filipinas, un destacamento español fue sitiado en el pueblo de Baler, en la isla filipina de Luzón, por insurrectos filipinos revolucionarios, durante 337 días. En diciembre de 1898, con la firma del Tratado de París entre España y Estados Unidos, se ponía fin formalmente a la guerra entre ambos países y España cedía la soberanía sobre Filipinas a Estados Unidos. Debido a esto, los sitiados en Baler son conocidos como los últimos de Filipinas"
                ,"Alejandro Hernández", R.drawable.los_ultimos_de_filipinas_mini,R.drawable.los_ultimos_de_filipinas));

        peliculas.add(new Pelicula(22,"Moana", "2016", "USA", 113, "John Musker, Ron Clements, Don Hall, Chris Williams"
                , "La historia se desarrolla hace dos milenios en unas islas del sur del Pacífico. La protagonista es Vaiana Waialiki, una joven que desea explorar el mundo navegando por el océano. Ella es la única hija de un importante capitán que pertenece a una familia con varias generaciones de marinos"
                , "Jared Bush", R.drawable.moana_mini, R.drawable.moana));

        peliculas.add(new Pelicula(33,"Villaviciosa de al lado", "2016", "España", 90,"Juanjo Javierre"
                ,"Quien no haya soñado alguna vez con que le tocaba la lotería que levante la mano. Todos hemos jugado a imaginar lo que haríamos si nos convirtiésemos en millonarios de la noche a la mañana: cambiar nuestro modesto utilitario por un descapotable de lujo, dejar nuestro tercero sin ascensor por un chalet con piscina y pista de pádel... o, simplemente, la satisfacción de hacerle al jefe un sonoro corte de mangas. Pero... ¿qué pasaría si se cumpliese ese sueño? ¿Qué pasaría si te tocase la lotería, encontrases la solución a todos tus problemas, pero no pudieras cobrar el premio porque al hacerlo todo el mundo descubriría tu afición a frecuentar a señoritas de moral distraída? "
                ,"Nacho G. Velilla, Oriol Capel, David S. Olivas, Antonio Sánchez", R.drawable.villaviciosa_de_al_lado_mini,R.drawable.villaviciosa_de_al_lado));

        peliculas.add(new Pelicula(44,"¿Quien engaño a Roger Rabbit?", "1988", "USA", 90,"Robert Zemeckis"
                ,"Hollywood, 1947. Eddie Valiant (Bob Hoskins), un detective de poca monta, ha sido contratado para encontrar pruebas que demuestren que Marvin Acme, magnate del negocio de los artículos de broma y dueño de Toontown, está rondando a Jessica Rabbit, mujer fatal y esposa de la superestrella del Marron Cartoon, Roger Rabbit. Cuando Acme aparece asesinado, todas las pruebas apuntan a Roger, y el siniestro y ambicioso Juez Doom (Christopher Lloyd) está decidido a condenarlo como sea. Roger suplica a Valiant que le ayude a encontrar al verdadero culpable, pero el asunto se irá complicando a medida que Eddie va descubriendo, escándalo tras escándalo, que la propia existencia de Toontown corre peligro. "
                ,"Jeffrey Price, Peter S. Seaman", R.drawable.who_framed_roger_rabbitmini,R.drawable.villaviciosa_de_al_lado));
    }
}

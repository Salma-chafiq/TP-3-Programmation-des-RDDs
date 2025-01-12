package sid.org;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class App1 {
  public static void main(String[] args) {
    // Étape 1 : Configurer Spark
    // - AppName : "TP 1 RDD" (nom de l'application)
    // - Master : "local[*]" (utiliser tous les cœurs disponibles sur le système local)
    SparkConf conf = new SparkConf().setAppName("TP 1 RDD").setMaster("local[*]");

    // Créer un contexte Spark
    JavaSparkContext sc = new JavaSparkContext(conf);

    // Étape 2 : Créer une liste d'entiers
    // Exemple de liste : [12, 8, 9, 18, 15, 19, 10, 17]
    List<Integer> values = Arrays.asList(12, 8, 9, 18, 15, 19, 10, 17);

    // Charger cette liste dans un RDD (paralléliser les données)
    JavaRDD<Integer> rdd1 = sc.parallelize(values);

    // Étape 3 : Transformation 1 - Mapper
    // Appliquer une transformation map pour ajouter 1 à chaque élément
    // Exemple : [12, 8, 9] devient [13, 9, 10]
    JavaRDD<Integer> rdd2 = rdd1.map(elem -> elem + 1);

    // Étape 4 : Transformation 2 - Filtrer
    // Appliquer un filtre pour conserver uniquement les éléments supérieurs ou égaux à 10
    // Exemple : [12, 8, 9, 18] -> [12, 18] (car 8 et 9 sont inférieurs à 10)
    JavaRDD<Integer> rdd3 = rdd1.filter(elem -> elem >= 10);

    // Étape 5 : Action - Collecter les résultats
    // collect() ramène les éléments de l'exécution Spark (distribuée) au programme principal
    List<Integer> result = rdd3.collect();

    // Afficher les résultats
    result.forEach(System.out::println); // Affiche chaque élément de la liste

    // Fermer le contexte Spark pour libérer les ressources
    sc.close();
  }
}

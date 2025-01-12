package sid.org;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.List;

public class App3 {
  public static void main(String[] args) {
    // Étape 1 : Configurer Spark
    // - AppName : "TotalVentesParVille" (nom de l'application)
    // - Master : "local" (mode d'exécution local)
    SparkConf conf = new SparkConf().setAppName("TotalVentesParVille").setMaster("local");
    JavaSparkContext sc = new JavaSparkContext(conf);

    // Étape 2 : Lire le fichier texte (ventes.txt)
    // On charge les lignes du fichier ventes.txt dans un RDD.
    // Chaque ligne représente une vente avec des informations comme la ville, le produit, et le prix.
    String filePath = "ventes.txt";
    JavaRDD<String> lines = sc.textFile(filePath);

    // Étape 3 : Mapper les données pour extraire (ville, prix)
    // Pour chaque ligne, on extrait la ville (index 1) et le prix (index 3).
    // On crée une paire (ville, prix) où ville est la clé et prix est la valeur.
    JavaRDD<Tuple2<String, Double>> villePrixPairs = lines.map(line -> {
      String[] parts = line.split(" ");  // Diviser chaque ligne en parties (date, ville, produit, prix)
      String ville = parts[1];  // Extraire la ville
      double prix = Double.parseDouble(parts[3]);  // Extraire le prix et le convertir en double
      return new Tuple2<>(ville, prix);  // Retourner une paire (ville, prix)
    });

    // Étape 4 : Réduire par clé pour calculer le total des ventes par ville
    // On utilise `reduceByKey` pour additionner les prix par ville.
    // Cette étape va regrouper toutes les ventes par ville et additionner les prix correspondants.
    JavaRDD<Tuple2<String, Double>> totalVentesParVille = villePrixPairs
      .mapToPair(vp -> new Tuple2<>(vp._1, vp._2))  // Transformer en une paire pour réduire
      .reduceByKey(Double::sum)  // Additionner les prix pour chaque ville
      .map(tuple -> new Tuple2<>(tuple._1, tuple._2));  // Transformer de nouveau pour avoir le bon format

    // Étape 5 : Collecter les résultats et les afficher
    // On collecte les résultats dans une liste et on les affiche pour chaque ville et son total de ventes.
    List<Tuple2<String, Double>> results = totalVentesParVille.collect();
    System.out.println("Total des ventes par ville :");
    for (Tuple2<String, Double> result : results) {
      System.out.println(result._1 + " : " + result._2 + " €");  // Affichage de la ville et de son total de ventes
    }

    // Étape 6 : Fermer le contexte Spark
    // Après l'exécution, on ferme le contexte Spark pour libérer les ressources.
    sc.close();
  }
}

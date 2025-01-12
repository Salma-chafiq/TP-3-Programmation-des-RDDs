package sid.org;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.List;

public class App4 {
  public static void main(String[] args) {
    // Étape 1 : Configurer Spark
    // - AppName : "TotalVentesParVilleProduit" (nom de l'application)
    // - Master : "local" (mode d'exécution local)
    SparkConf conf = new SparkConf().setAppName("TotalVentesParVilleProduit").setMaster("local");
    JavaSparkContext sc = new JavaSparkContext(conf);

    // Étape 2 : Définir le chemin du fichier texte contenant les ventes
    String filePath = "ventes.txt";

    // Année à filtrer (par exemple 2025)
    String annee = "2025";

    // Étape 3 : Lire le fichier texte dans un RDD
    // Le fichier contient des informations sur les ventes sous la forme :
    // date ville produit prix
    JavaRDD<String> lines = sc.textFile(filePath);

    // Étape 4 : Filtrer les lignes pour ne conserver que celles correspondant à l'année spécifiée
    // On filtre par date (on garde seulement les lignes commençant par l'année 2025)
    JavaRDD<String> lignesFiltrees = lines.filter(line -> line.startsWith(annee));

    // Étape 5 : Extraire les informations nécessaires (ville, produit, prix)
    // Pour chaque ligne filtrée, on extrait la ville, le produit et le prix
    // Puis on crée une paire (clé, valeur) où la clé est un tuple (ville, produit)
    // et la valeur est le prix
    JavaPairRDD<Tuple2<String, String>, Double> villeProduitPrixPairs = lignesFiltrees.mapToPair(line -> {
      String[] parts = line.split(" ");  // Diviser la ligne en parties
      String ville = parts[1];  // Extraire la ville
      String produit = parts[2];  // Extraire le produit
      double prix = Double.parseDouble(parts[3]);  // Extraire et convertir le prix en double
      return new Tuple2<>(new Tuple2<>(ville, produit), prix);  // Retourner une paire (ville, produit) -> prix
    });

    // Étape 6 : Calculer le total des ventes pour chaque paire (ville, produit)
    // La méthode reduceByKey additionne les prix pour chaque paire (ville, produit)
    JavaPairRDD<Tuple2<String, String>, Double> totalParVilleProduit = villeProduitPrixPairs.reduceByKey(Double::sum);

    // Étape 7 : Collecter les résultats et les afficher
    List<Tuple2<Tuple2<String, String>, Double>> result = totalParVilleProduit.collect();

    // Afficher les résultats : le total des ventes pour chaque ville et produit
    System.out.println("Prix total des ventes par ville et par produit pour l'année " + annee + ":");
    for (Tuple2<Tuple2<String, String>, Double> entry : result) {
      Tuple2<String, String> villeProduit = entry._1;  // Extraire la ville et le produit
      Double total = entry._2;  // Extraire le total des ventes
      System.out.println("Ville: " + villeProduit._1 + ", Produit: " + villeProduit._2 + ", Total: " + total);
    }

    // Étape 8 : Fermer le contexte Spark après exécution
    sc.close();
  }
}

package sid.org;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class App2 {
  public static void main(String[] args) {
    // Configurer Spark
    // - AppName : "TP Word Count" (nom de l'application)
    // - Master : "local[*]" (exécuter en mode local avec tous les cœurs disponibles)
    SparkConf conf = new SparkConf().setAppName("TP Word Count").setMaster("local[*]");

    // Créer un contexte Spark
    JavaSparkContext sc = new JavaSparkContext(conf);

    // Étape 1 : Charger le fichier texte dans un RDD
    // Le fichier "words.txt" contient les données à traiter (une ligne de texte par ligne)
    JavaRDD<String> rddLines = sc.textFile("words.txt");

    // Étape 2 : Séparer chaque ligne en mots
    // Utilisation de `flatMap` pour diviser chaque ligne en une liste de mots en utilisant un séparateur (" ")
    JavaRDD<String> rddWords = rddLines.flatMap((line) -> Arrays.asList(line.split(" ")).iterator());

    // Étape 3 : Transformer chaque mot en une paire (mot, 1)
    // Exemple : Si un mot est "apple", il sera transformé en ("apple", 1)
    JavaPairRDD<String, Integer> rddPairWords = rddWords.mapToPair(word -> new Tuple2<>(word, 1));

    // Étape 4 : Compter les occurrences de chaque mot
    // `reduceByKey` regroupe les paires ayant la même clé (le même mot)
    // et additionne leurs valeurs
    JavaPairRDD<String, Integer> rddWordCount = rddPairWords.reduceByKey((a, b) -> a + b);

    // Étape 5 : Collecter les résultats et les afficher
    // Utilisation de `foreach` pour imprimer chaque paire (mot, nombre d'occurrences)
    rddWordCount.foreach(elem -> System.out.println(elem._1() + " " + elem._2()));

    // Fermer le contexte Spark après exécution
    sc.close();
  }
}

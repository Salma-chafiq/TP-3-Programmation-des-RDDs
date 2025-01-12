<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README</title>
</head>
<body>
    <h1>Projet Spark - TP avec RDD et Transformation</h1>

    <p><strong>Description :</strong></p>
    <p>Ce projet utilise Apache Spark pour effectuer différentes opérations sur des données distribuées à l'aide de RDD (Resilient Distributed Datasets) et de transformations basiques. L'application est composée de plusieurs classes Java exécutant différentes tâches liées à l'analyse de données telles que le comptage de mots et le calcul de ventes totales par ville.</p>

    <h2>Structure du Projet</h2>
    <pre>
    ├── pom.xml
    ├── src/
    │   ├── sid/org/
    │   │   ├── App1.java
    │   │   ├── App2.java
    │   │   ├── App3.java
    │   │   └── App4.java
    └── README.md
    </pre>

    <h2>Technologies Utilisées</h2>
    <ul>
        <li>Apache Spark</li>
        <li>Java 8</li>
        <li>Maven</li>
    </ul>

    <h2>Installation</h2>
    <p>Pour commencer à utiliser ce projet, veuillez suivre les étapes ci-dessous :</p>
    <ol>
        <li><strong>Cloner le dépôt</strong> :
            <pre>git clone https://github.com/votre-utilisateur/nom-du-repository.git</pre>
        </li>
        <li><strong>Configurer Maven</strong> :
            <p>Assurez-vous que Maven est installé sur votre machine. Si ce n'est pas le cas, vous pouvez l'installer en suivant les instructions <a href="https://maven.apache.org/install.html" target="_blank">ici</a>.</p>
        </li>
        <li><strong>Installer les dépendances</strong> :
            <pre>mvn install</pre>
        </li>
        <li><strong>Exécuter l'application</strong> :
            <p>Vous pouvez exécuter les différentes applications en utilisant Maven :</p>
            <pre>mvn exec:java -Dexec.mainClass="sid.org.App1"</pre>
            <pre>mvn exec:java -Dexec.mainClass="sid.org.App2"</pre>
            <pre>mvn exec:java -Dexec.mainClass="sid.org.App3"</pre>
            <pre>mvn exec:java -Dexec.mainClass="sid.org.App4"</pre>
        </li>
    </ol>

    <h2>Fonctionnalités</h2>
    <ul>
        <li><strong>App1 :</strong> Applique des transformations sur un RDD d'entiers (ajouter 1 et filtrer les éléments supérieurs ou égaux à 10).</li>
        <li><strong>App2 :</strong> Effectue un comptage des mots dans un fichier texte (Word Count).</li>
        <li><strong>App3 :</strong> Calcule le total des ventes par ville à partir d'un fichier de ventes.</li>
        <li><strong>App4 :</strong> Calcule le total des ventes par ville et par produit pour une année spécifique (ex. 2025).</li>
    </ul>

    <h2>Exemple de Code</h2>

    <h3>App1 - RDD Transformation</h3>


    <h3>App2 - Word Count</h3>


    <h3>App3 - Total des Ventes par Ville</h3>


    <h2>Contribuer</h2>
    <p>Si vous souhaitez contribuer à ce projet, n'hésitez pas à forker le dépôt et à soumettre une pull request avec vos améliorations.</p>

    <h2>Licence</h2>
    <p>Ce projet est sous licence MIT.</p>
</body>
</html>

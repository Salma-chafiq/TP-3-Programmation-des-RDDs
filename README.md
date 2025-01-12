<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projet Spark - TP avec RDD et Transformation</title>
</head>
<body>
    <h1>Projet Spark - TP avec RDD et Transformation</h1>

    <h2>Description</h2>
    <p>
        Ce projet utilise Apache Spark pour effectuer différentes opérations sur des données distribuées à l'aide de RDD (Resilient Distributed Datasets) et de transformations basiques. L'application est composée de plusieurs classes Java exécutant différentes tâches liées à l'analyse de données, telles que le comptage de mots et le calcul de ventes totales par ville.
    </p>

    <h2>Objectifs</h2>
    <ul>
        <li>Effectuer des transformations et actions de base avec RDD dans Apache Spark.</li>
        <li>Appliquer des opérations telles que le comptage des mots et le calcul de totaux sur des ensembles de données distribuées.</li>
        <li>Développer des applications Java utilisant Spark pour traiter des données en mode local.</li>
    </ul>

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
        <li><strong>Apache Spark</strong> : pour le traitement des données distribuées.</li>
        <li><strong>Java 8</strong> : pour la programmation.</li>
        <li><strong>Maven</strong> : pour la gestion des dépendances et l'exécution du projet.</li>
    </ul>

    <h2>Installation</h2>
    <p>Pour commencer à utiliser ce projet, veuillez suivre les étapes ci-dessous :</p>
    <ol>
        <li><strong>Cloner le dépôt :</strong>
            <pre>
            git clone https://github.com/votre-utilisateur/nom-du-repository.git
            </pre>
        </li>
        <li><strong>Configurer Maven :</strong>
            <p>Assurez-vous que Maven est installé sur votre machine. Si ce n'est pas le cas, vous pouvez l'installer en suivant les instructions <a href="https://maven.apache.org/install.html" target="_blank">ici</a>.</p>
        </li>
        <li><strong>Installer les dépendances :</strong>
            <pre>
            mvn install
            </pre>
        </li>
        <li><strong>Exécuter l'application :</strong>
            <p>Vous pouvez exécuter les différentes applications en utilisant Maven :</p>
            <pre>
            mvn exec:java -Dexec.mainClass="sid.org.App1"
            mvn exec:java -Dexec.mainClass="sid.org.App2"
            mvn exec:java -Dexec.mainClass="sid.org.App3"
            mvn exec:java -Dexec.mainClass="sid.org.App4"
            </pre>
        </li>
    </ol>

    <h2>Fonctionnalités</h2>
    <ul>
        <li><strong>App1</strong> : Applique des transformations sur un RDD d'entiers (ajouter 1 et filtrer les éléments supérieurs ou égaux à 10).</li>
        <li><strong>App2</strong> : Effectue un comptage des mots dans un fichier texte (Word Count).</li>
        <li><strong>App3</strong> : Calcule le total des ventes par ville à partir d'un fichier de ventes.</li>
        <li><strong>App4</strong> : Calcule le total des ventes par ville et par produit pour une année spécifique (ex. 2025).</li>
    </ul>

    <h2>Contributions</h2>
    <p>Les contributions au projet sont les bienvenues ! Pour contribuer :</p>
    <ol>
        <li>Fork ce dépôt.</li>
        <li>Crée une branche (<code>git checkout -b feature/xyz</code>).</li>
        <li>Commit tes changements (<code>git commit -am 'Ajout d'une nouvelle fonctionnalité'</code>).</li>
        <li>Push sur la branche (<code>git push origin feature/xyz</code>).</li>
        <li>Ouvre une pull request.</li>
    </ol>

    <h2>Licence</h2>
    <p>Ce projet est sous licence <a href="https://opensource.org/licenses/MIT" target="_blank">MIT</a>.</p>

    <h2>Captures d'écran</h2>
    <h3>App1 - Transformation sur RDD</h3>
    <img src="Capture/screenshot_app1.png" alt="App1 - Transformation sur RDD" style="width: 80%;">

    <h3>App2 - Comptage des mots</h3>
    <img src="Capture/screenshot_app2.png" alt="App2 - Comptage des mots" style="width: 80%;">

    <h3>App3 - Calcul des ventes par ville</h3>
    <img src="Capture/screenshot_app3.png" alt="App3 - Calcul des ventes par ville" style="width: 80%;">

    <h3>App4 - Ventes par ville et produit</h3>
    <img src="Capture/screenshot_app4.png" alt="App4 - Ventes par ville et produit" style="width: 80%;">

</body>
</html>

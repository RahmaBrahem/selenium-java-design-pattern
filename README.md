<h1 align="center">🧰 Selenium Java Test Automation Framework (Design Pattern Based)</h1>
<p align="center"><i>Modular, maintainable automation with Java, Selenium & TestNG</i></p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white" />
  <img src="https://img.shields.io/badge/TestNG-F2A100?style=for-the-badge&logo=testng&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" />
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/build-passing-brightgreen?style=for-the-badge&logo=github" />
  <img src="https://img.shields.io/badge/Version-1.0-blue?logoColor=rgb(0%2C%200%2C%20255)&label=Version" />
</p>

Ce projet est un framework d'automatisation de tests UI développé en Java avec Selenium WebDriver et TestNG. Il adopte une architecture claire, modulaire et maintenable, en s'appuyant notamment sur le modèle Page Object (POM) pour structurer les interactions avec l'interface utilisateur.

## 🚀 Objectifs

- 📌 **Fournir un modèle de base réutilisable** pour tout projet d’automatisation UI  
- 📌 **Séparer clairement les responsabilités** grâce à des packages dédiés  
- 📌 **Appliquer les bonnes pratiques** de design logiciel  
- 📌 **Générer des rapports clairs et exploitables**  
- 📌 **Assurer une gestion robuste des erreurs** (captures d’écran, logs, timeout, etc.)  

## 🧱 Architecture du Projet

L’organisation du code suit une architecture modulaire clairement séparée par packages et types de fichiers :

📁 **/Design-Pattern**  
├── 📁 **src/main/java/**  
│   ├── 📦 **com.config.reader**           → Chargement de la configuration  
│   ├── 📦 **com.driver.factory**          → Instanciation centralisée du WebDriver (Chrome, Firefox, Edge)  
│   ├── 📦 **com.pages**                   → Page Object Model (POM)  
│   ├── 📦 **com.report.config**           → Configuration des rapports  
│   ├── 📦 **com.utils.elements**          → Méthodes utilitaires pour les éléments web  
│   ├── 📦 **com.utils.screen.shot**       → Captures d’écran automatiques  
│   └── 📦 **com.utils.wait**              → Attentes explicites centralisées  

├── 📁 **src/test/java/**  
│   ├── 🧪 **com.base.de.test**            → Classe de base pour le setup des tests  
│   └── 🧪 **com.tests**                   → Cas de test automatisés  

├── 📁 **src/test/resources/dataConfig/**  
│   └── 📄 **data.properties**             → Fichier de configuration (non versionné Git)  

└── 📄 **testng.xml**                      → Fichier de configuration TestNG  


## 🛠️ Technologies & Librairies 

- **Java 21 (OpenJDK)**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **WebDriverManager**
- **ExtentReports**
- Fichier .properties pour la configuration

## 🔍 Page Object Model (POM)

Le projet utilise le modèle **Page Object Model (POM)** pour structurer le code de test de manière claire et réutilisable.

Chaque classe dans le package `com.pages` représente une page de l’application et contient :
- Les localisateurs des éléments UI  
- Les méthodes d’interaction avec ces éléments  
- Une interface simple à utiliser dans les cas de test

## ⚙️ Configuration

Le fichier `data.properties` contient toutes les données de configuration nécessaires au projet : URL, identifiants, messages, options navigateur, etc.  
🔒 Ce fichier est **ignoré** par Git (via `.gitignore`) pour ne pas exposer d’informations sensibles.  
📁 Un **exemple de configuration** est fourni ici : [`properties-example.txt`](properties-example.txt)

### 🛠️ Pour configurer le projet localement :

1. **Créer** le dossier `dataConfig` dans `src/test/resources/` (s’il n’existe pas déjà)  
2. **Copier** le fichier `properties-example.txt` dans ce dossier  
3. **Renommer** ce fichier en `data.properties`  
4. **Modifier** son contenu avec vos propres données : `url`, `usernamevalid`, `passwordvalid`, `errormsgLogin`, etc.  

✅ Ce fichier est lu par la classe `ConfigReader`, qui charge les propriétés et les rend accessibles aux classes de test via des méthodes dédiées.

## ▶️ Exécution des Tests

### Avec Maven (ligne de commande) :

```bash
mvn clean test
````

### Avec Eclipse :

* Clic droit sur `testng.xml`
* Choisir **Run As > TestNG Suite**

## 📊 Résultats et Rapports

Les résultats des tests sont organisés dans des dossiers dédiés, avec des fichiers nommés dynamiquement selon la date, l’heure et parfois le nom de la méthode de test.  
Le format de date/heure est défini dans `data.properties` (ex: `yy_MM_dd_HH_mm_ss`) et appliqué via la méthode `getActualDateTime()` de la classe `ConfigReader`.

### 📁 Rapport HTML
- 📂 Emplacement : `target/Spark/`
- 📝 Exemple de nom : `SparkReport_25_07_26_11_13_46.html`

### 📸 Captures d’écran
- 📂 Emplacement : `target/Screenshots/`
- 📝 Exemple de nom : `Image_failedLoginTest_25_07_26_11_13_48.png`

### 🎥 Vidéos de test 
- 📂 Emplacement : `target/Videos/`
- 📝 Exemple de nom : `Video_successfulLoginTest_25_07_26_11_13_50.mov`

## ✔️ Bonnes pratiques suivies

* Clean Code
* Séparation claire des responsabilités (SRP)
* Design Patterns appliqués
* Données de test externalisées
* Utilisation des assertions (TestNG)
* Rapports lisibles
* Tests réutilisables
* Tests faciles à maintenir
* Exécution headless possible

## ✨ Évolutions futures (TODO réalistes)

Voici quelques pistes d’amélioration pour les prochaines versions :
- Intégrer Jenkins pour l'exécution continue (CI/CD)
- Activer l'exécution parallèle via TestNG XML (`parallel="methods"`)
- Prévoir un module de test d’API (RestAssured)
- Support multi-navigateurs déjà intégré (Chrome, Firefox, Edge)

## ✍️ Auteur

  <strong>Rahma Brahem</strong><br>
  <em>QA Engineer | Passionnée par l'automatisation</em><br>
  📎 <a href="https://github.com/RahmaBrahem">GitHub</a> &nbsp;|&nbsp;
  <a href="https://www.linkedin.com/in/rahmabrahemqa">LinkedIn</a> 

## 📜 Licence

Ce projet est publié sous la licence [MIT](https://opensource.org/licenses/MIT).  
Voir le fichier [LICENSE](./LICENSE) pour plus de détails.

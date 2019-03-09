package com.eseokami.romainrabouan.eseokamijava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class PrivacyPolicy extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        tv = (TextView) findViewById(R.id.textViewPrivacy);

        loadText();
    }

    private void loadText() {
        String s = "Politique de Confidentialité\n" +
                "Date de prise d'effet: December 28, 2018\n" +
                "Eseo Kami (\"nous\", \"notre\", \"nos\") exploite l'application mobile Eseo Kami (ci-après désignée par le terme \"Service\").\n" +
                "Cette page vous explique nos politiques en matière de collecte, d'utilisation et de communication des données à caractère personnel lorsque vous utilisez notre Service ainsi que les choix qui s'offrent à vous en ce qui concerne ces données.\n" +
                "Nous utilisons vos données pour fournir et améliorer le Service. En utilisant le Service, vous consentez à la collecte et à l'utilisation d'informations conformément à la présente politique. Sauf définition contraire dans la présente Politique de Confidentialité, les termes utilisés dans la présente Politique de Confidentialité ont la même signification que dans nos Conditions Générales.\n" +
                "Définitions\n" +
                "Service\n" +
                "Par Service on entend l'application mobile Eseo Kami exploitée par Eseo Kami\n" +
                "Données à caractère personnel\n" +
                "Données à Caractère Personnel désigne des données concernant un individu vivant qui peut être identifié à partir de ces données (ou à partir de ces données et d'autres informations en notre possession ou susceptibles d'entrer en notre possession).\n" +
                "Données d'Utilisation\n" +
                "Les Données d'Utilisation sont recueillies automatiquement et sont générées soit par l'utilisation du Service, soit par l'infrastructure du Service proprement dite (par exemple, durée de consultation d'une page).\n" +
                "Cookies\n" +
                "Les cookies sont de petits fichiers enregistrés sur votre dispositif (ordinateur ou dispositif mobile).\n" +
                "Collecte et utilisation des données\n" +
                "Nous recueillons plusieurs types de données à différentes fins en vue de vous fournir notre Service et de l'améliorer.\n" +
                "Types de données recueillies\n" +
                "Données à Caractère Personnel\n" +
                "Lorsque vous utilisez notre Service, il est possible que nous vous demandions de nous fournir certaines données personnelles nominatives qui peuvent servir à vous contacter ou à vous identifier (\"Données à Caractère Personnel\"). Les données personnelles nominatives peuvent comprendre, mais de manière non limitative:\n" +
                "Prénom et nom de famille\n" +
                "Adresse, ville, province, état, code postal\n" +
                "Cookies et Données d'Utilisation\n" +
                "Données d'Utilisation\n" +
                "Lorsque vous accédez au Service au moyen d'un dispositif mobile, il se peut que nous recueillions certaines informations automatiquement, y compris, mais de manière non limitative, le type de dispositif mobile que vous utilisez, l'identifiant unique de votre dispositif mobile, l'adresse IP de votre dispositif mobile, votre système d'exploitation mobile, le type de navigateur Internet mobile que vous utilisez, les identifiants uniques de dispositifs ainsi que d'autres données de diagnostic (\"Données d'Utilisation\").\n" +
                "Suivi et données de cookies\n" +
                "Nous avons recours à des cookies et à d'autres technologies de suivi similaires pour effectuer un suivi des activités effectuées dans notre Service, et nous conservons certaines informations.\n" +
                "Les cookies sont des fichiers à faible volume de données pouvant comporter un identifiant unique anonyme. Les cookies sont envoyés à votre navigateur depuis un site web et sont stockés sur votre dispositif. D'autres technologies de suivi telles que les pixels, les balises et les scripts sont également utilisées pour recueillir et suivre des informations et afin d'améliorer et d'analyser notre Service.\n" +
                "Vous pouvez demander à votre navigateur de refuser tous les cookies ou de vous avertir lorsqu'un cookie est envoyé. Toutefois, si vous n'acceptez pas les cookies, il se peut que vous ne puissiez pas utiliser certains éléments de notre Service.\n" +
                "Exemples de cookies que nous utilisons :\n" +
                "Cookies de Session. Nous utilisons des Cookies de Session pour faire fonctionner notre Service.\n" +
                "Cookies de Préférences. Nous utilisons des Cookies de Préférences pour mémoriser vos préférences et vos différents paramètres.\n" +
                "Cookies de Sécurité. Nous utilisons des Cookies de Sécurité pour des raisons de sécurité.\n" +
                "Utilisation des données\n" +
                "Eseo Kami utilise les données recueillies à des fins diverses:\n" +
                "Pour fournir et assurer notre Service\n" +
                "Pour vous faire part des changements apportés à notre Service\n" +
                "Pour vous permettre d'utiliser les fonctions interactives de notre Service quand vous le souhaitez\n" +
                "Pour assurer l'assistance client\n" +
                "Pour recueillir des données précieuses ou d'analyses qui nous permettront d'améliorer notre Service\n" +
                "Pour contrôler l'utilisation de notre Service\n" +
                "Pour détecter, prévenir et régler les problèmes techniques\n" +
                "Transfert des données\n" +
                "Les informations vous concernant, notamment vos Données à Caractère Personnel, peuvent être transférées de votre région, province, pays, ou autre division territoriale vers des ordinateurs – et stockées sur ces derniers – situés à un endroit où la législation relative à la protection des données diffère de celle du territoire où vous résidez.\n" +
                "Si vous résidez hors de/du France et que vous choisissez de nous communiquer des informations, sachez que nous transférons les données, y compris les Données à Caractère Personnel, vers le/la France et que nous les y traitons.\n" +
                "En acceptant la présente Politique de Confidentialité puis en soumettant ces informations, vous consentez à ce transfert.\n" +
                "Eseo Kami prendra toutes les mesures raisonnablement nécessaires pour faire en sorte que vos données soient traitées de manière sécurisée et conformément à la présente Politique de Confidentialité et vos Données à Caractère Personnel ne seront transférées vers aucune organisation ni aucun pays à moins que des contrôles adéquats ne soient en place, notamment en ce qui concerne la sécurité de vos données et d'autres données personnelles.\n" +
                "Communication de données\n" +
                "Exigences légales\n" +
                "Eseo Kami peut communiquer vos Données à Caractère Personnel si elle estime de bonne foi que cela est nécessaire pour:\n" +
                "S'acquitter d'une obligation légale\n" +
                "Protéger et défendre les droits ou les biens de Eseo Kami\n" +
                "Prévenir d'éventuels actes répréhensibles ou enquêter sur de tels actes dans le cadre du Service\n" +
                "Assurer la sécurité personnelle des utilisateurs du Service ou du public\n" +
                "Se protéger contre la responsabilité civile\n" +
                "Sécurité des données\n" +
                "La sécurité de vos données nous tient à cœur. Toutefois, n'oubliez pas qu'aucune méthode de transmission de données par Internet ou méthode de stockage électronique n'est sûre à 100 %. Bien que nous nous efforcions d'utiliser des méthodes commercialement acceptables pour protéger vos Données à Caractère Personnel, nous ne pouvons pas leur garantir une sécurité absolue.\n" +
                "Prestataires de services\n" +
                "Nous pouvons faire appel à des sociétés tierces et à des tierces personnes pour faciliter la prestation de notre Service (\"Prestataires de Services\"), assurer le Service en notre nom, assurer des services liés au Service ou nous aider à analyser la façon dont notre Service est utilisé.\n" +
                "Ces tiers n'ont accès à vos Données à Caractère Personnel que pour effectuer ces tâches en notre nom et il leur est interdit de les communiquer ou de les utiliser à quelle qu'autre fin.\n" +
                "Analyses\n" +
                "Nous pouvons faire appel à des Prestataires de Services tiers pour surveiller et analyser l'utilisation de notre Service.\n" +
                "Google Analytics\n" +
                "Google Analytics est un service d'analyse web proposé par Google qui assure le suivi du trafic d'un site web et en rend compte. Google utilise les données recueillies pour suivre et surveiller l'utilisation de notre Service. Ces données sont partagées avec d'autres services Google. Google peut utiliser les données recueillies pour contextualiser et personnaliser les annonces de son propre réseau publicitaire.\n" +
                "Vous pouvez refuser certaines fonctionnalités de Google Analytics en utilisant les paramètres de votre dispositif mobile, par exemple ses paramètres publicitaires, ou en suivant les instructions qui figurent dans la politique de confidentialité de Google: https://policies.google.com/privacy?hl=en\n" +
                "Pour plus de précisions sur les pratiques de confidentialité de Google, merci de consulter la page web Protection de la vie privée et conditions de Google: https://policies.google.com/privacy?hl=en\n" +
                "Firebase\n" +
                "Firebase est un service d'analyse fourni par Google Inc.\n" +
                "Vous pouvez refuser certaines fonctionnalités de Firebase en utilisant les paramètres de votre dispositif mobile, par exemple ses paramètres publicitaires, ou en suivant les instructions qui figurent dans la politique de confidentialité de Google: https://policies.google.com/privacy?hl=en\n" +
                "Nous vous encourageons également à consulter la politique de Google relative à la protection de vos données: https://support.google.com/analytics/answer/6004245.\n" +
                "Pour plus de précisions sur le type de données recueillies par Firebase, merci de consulter la page web Protection de la vie privée et conditions de Google https://policies.google.com/privacy?hl=en\n" +
                "Liens pointant vers d'autres sites\n" +
                "Il se peut que notre Service contienne des liens pointant vers d'autres sites que nous n'exploitons pas. Si vous cliquez sur un lien de tiers, vous serez redirigé vers le site de ce tiers. Nous vous recommandons vivement d'examiner la politique de confidentialité de chacun des sites que vous consultez.\n" +
                "Nous n'avons aucun contrôle sur le contenu, les politiques ou pratiques de confidentialité des sites ou services de tiers et déclinons toute responsabilité en ce qui les concerne.\n" +
                "Vie privée des enfants\n" +
                "Notre Service ne s'adresse pas aux personnes de moins de 18 ans (\"Enfants\").\n" +
                "Nous ne recueillons pas sciemment de données personnelles nominatives auprès de personnes de moins de 18 ans. Si vous êtes un parent ou un tuteur et que vous savez que votre Enfant nous a communiqué des Données à Caractère Personnel, veuillez nous contacter. Si nous apprenons que nous avons recueilli des Données à Caractère Personnel auprès d'enfants sans vérifier s'il y a consentement parental, nous faisons le nécessaire pour supprimer ces informations de nos serveurs.\n" +
                "Modifications de la présente Politique de Confidentialité\n" +
                "Nous nous réservons le droit d'actualiser notre Politique de Confidentialité de temps à autre. Nous vous informerons de toute modification en publiant la nouvelle Politique de Confidentialité sur cette page.\n" +
                "Avant que la modification ne prenne effet, nous vous en informerons par e-mail et/ ou en plaçant un avis bien en vue dans notre Service et nous actualiserons la \"date de prise d'effet\" qui figure en haut de la présente Politique de Confidentialité.\n" +
                "Nous vous conseillons de consulter la présente Politique de Confidentialité périodiquement pour prendre connaissance de toute modification. Les modifications apportées à la présente Politique de Confidentialité prennent effet lorsqu'elles sont publiées sur cette page.\n" +
                "Nous contacter\n" +
                "Pour toute question relative à la présente Politique de Confidentialité, veuillez nous contacter:\n" +
                "Par courrier électronique: romain.rabouan@reseau.eseo.fr\n" +
                "pierre.bertier@reseau.eseo.fr\n";

        tv.setText(s);
        tv.setMovementMethod(new ScrollingMovementMethod());
    }



}

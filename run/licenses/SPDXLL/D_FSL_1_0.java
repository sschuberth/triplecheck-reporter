package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:44:16Z
 * LicenseName: Apache-2.0
 * FileName: D_FSL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class D_FSL_1_0 extends License{
   /**
     * Was this license approved by the OSI?
     * @return  True if the license is listed as approved   
     */
    @Override
    public Boolean approvedOSI(){
        return false; // was this license OSI approved or not?
    }
    
    /**
     * The SPDX identifier
     * @return  The unique identifier for this license
     */
    @Override
    public String getId(){
        return "D-FSL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Deutsche Freie Software Lizenz"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Deutsche Freie Software Lizenz\n"
        + "\n"
        + "(c) Ministerium für Wissenschaft und Forschung Nordrhein-Westfalen 2004\n"
        + "\n"
        + "Erstellt von Axel Metzger und Till Jaeger, Institut für Rechtsfragen der Freien "
        + "und Open Source Software - (http://www.ifross.de).\n"
        + "\n"
        + "Präambel\n"
        + "\n"
        + "Software ist mehr als ein Wirtschaftsgut. Sie ist die technische Grundlage der I"
        + "nformationsgesellschaft. Die Frage der Teilhabe der Allgemeinheit ist deswegen v"
        + "on besonderer Bedeutung. Herkömmlich lizenzierte Programme werden nur im Object "
        + "Code vertrieben, der Nutzer darf das Programm weder verändern noch weitergeben. "
        + "Das Lizenzmodell der Freien Software (synonym \"Open Source Software\") gewährt Ih"
        + "nen dagegen umfassende Freiheiten im Umgang mit dem Programm. Die Deutsche Freie"
        + " Software Lizenz folgt diesem Lizenzmodell. Sie gewährt Ihnen das Recht, das Pro"
        + "gramm in umfassender Weise zu nutzen. Es ist Ihnen gestattet, das Programm nach "
        + "Ihren Vorstellungen zu verändern, in veränderter oder unveränderter Form zu verv"
        + "ielfältigen, zu verbreiten und öffentlich zugänglich zu machen. Diese Rechte wer"
        + "den unentgeltlich eingeräumt.\n"
        + "\n"
        + "Die Deutsche Freie Software Lizenz verbindet die Rechtseinräumung allerdings mit"
        + " Pflichten, die dem Zweck dienen, das freie Zirkulieren des Programms und aller "
        + "veröffentlichten Fortentwicklungen zu sichern. Wenn Sie das Programm verbreiten "
        + "oder öffentlich zugänglich machen, dann müssen Sie jedem, der das Programm von I"
        + "hnen erhält, eine Kopie dieser Lizenz mitliefern und den Zugriff auf den Source "
        + "Code ermöglichen. Eine weitere Pflicht betrifft Fortentwicklungen des Programms."
        + " Änderungen am Programm, die Sie öffentlich verbreiten oder zugänglich machen, m"
        + "üssen nach den Bestimmungen dieser Lizenz frei gegeben werden.\n"
        + "\n"
        + "Die Deutsche Freie Software Lizenz nimmt auf die besonderen Anforderungen des de"
        + "utschen und europäischen Rechts Rücksicht. Sie ist zweisprachig gestaltet und da"
        + "mit auch auf den internationalen Vertrieb ausgerichtet.\n"
        + "\n"
        + "§ 0 Definitionen\n"
        + "\n"
        + "Dokumentation: Die Beschreibung des Aufbaus und/oder der Struktur der Programmie"
        + "rung und/oder der Funktionalitäten des Programms, unabhängig davon, ob sie im So"
        + "urce Code oder gesondert vorgenommen wird.\n"
        + "\n"
        + "Lizenz: Die zwischen dem Lizenzgeber und Ihnen geschlossene Vereinbarung mit dem"
        + " Inhalt der \"Deutschen Freien Software Lizenz\" bzw. das Angebot hierzu.\n"
        + "\n"
        + "Lizenznehmer: Jede natürliche oder juristische Person, die die Lizenz angenommen"
        + " hat.\n"
        + "\n"
        + "Programm: Jedes Computerprogramm, das von den Rechtsinhabern nach den Bestimmung"
        + "en dieser Lizenz verbreitet oder öffentlich zugänglich gemacht worden ist.\n"
        + "\n"
        + "Object Code: Die maschinenlesbare, übersetzte Form des Programms.\n"
        + "\n"
        + "Öffentlich: Nicht nur an einen bestimmten Personenkreis gerichtet, der persönlic"
        + "h oder durch die Zugehörigkeit zu einer juristischen Person oder einem öffentlic"
        + "hen Träger miteinander verbunden ist.\n"
        + "\n"
        + "Öffentlich zugänglich machen: Die öffentliche Weitergabe des Programms in unkörp"
        + "erlicher Form, insbesondere das Bereithalten zum Download in Datennetzen.\n"
        + "\n"
        + "Rechtsinhaber: Der bzw. die Urheber oder sonstigen Inhaber der ausschließlichen "
        + "Nutzungsrechte an dem Programm.\n"
        + "\n"
        + "Source Code: Die für Menschen lesbare, in Programmiersprache dargestellte Form d"
        + "es Programms.\n"
        + "\n"
        + "Verändern: Jede Erweiterung, Kürzung und Bearbeitung des Programms, insbesondere"
        + " Weiterentwicklungen.\n"
        + "\n"
        + "Verbreiten: Die öffentliche Weitergabe körperlicher Vervielfältigungsstücke, ins"
        + "besondere auf Datenträgern oder in Verbindung mit Hardware.\n"
        + "\n"
        + "Vollständiger Source Code: Der Source Code in der für die Erstellung bzw. die Be"
        + "arbeitung benutzten Form zusammen mit den zur Übersetzung und Installation erfor"
        + "derlichen Konfigurationsdateien und Software-Werkzeugen, sofern diese in der ben"
        + "ötigten Form nicht allgemein gebräuchlich (z.B. Standard-Kompiler) oder für jede"
        + "rmann lizenzgebührenfrei im Internet abrufbar sind.\n"
        + "\n"
        + "§ 1 Rechte\n"
        + "\n"
        + "(1) Sie dürfen das Programm in unveränderter Form vervielfältigen, verbreiten un"
        + "d öffentlich zugänglich machen.\n"
        + "\n"
        + "(2) Sie dürfen das Programm verändern und entsprechend veränderte Versionen verv"
        + "ielfältigen, verbreiten und öffentlich zugänglich machen. Gestattet ist auch die"
        + " Kombination des Programms oder Teilen hiervon mit anderen Programmen.\n"
        + "\n"
        + "(3) Sie erhalten die Rechte unentgeltlich.\n"
        + "\n"
        + "§ 2 Pflichten beim Vertrieb\n"
        + "\n"
        + "(1) Wenn Sie das Programm verbreiten oder öffentlich zugänglich machen, sei es i"
        + "n unveränderter oder veränderter Form, sei es in einer Kombination mit anderen P"
        + "rogrammen oder in Verbindung mit Hardware, dann müssen sie mitliefern:\n"
        + "1. alle Vermerke im Source Code und/oder Object Code, die auf diese Lizenz hinwe"
        + "isen;\n"
        + "2. alle Vermerke im Source Code und/oder Object Code, die über die Urheber des P"
        + "rogramms Auskunft geben;\n"
        + "3. einen für den Empfänger deutlich wahrnehmbaren Hinweis auf diese Lizenz und d"
        + "ie Internetadresse http://www.d-fsl.de;\n"
        + "4. den vollständigen Text dieser Lizenz in deutlich wahrnehmbarer Weise.\n"
        + "\n"
        + "(2) Wenn bei der Installation des Programms und/oder beim Programmstart Lizenz- "
        + "und/oder Vertragsbedingungen angezeigt werden, dann müssen\n"
        + "1. diese Lizenz,\n"
        + "2. ein Hinweis auf diese Lizenz und\n"
        + "3. ein Hinweis auf den oder die Rechtsinhaber an den ersten unter dieser Lizenz "
        + "nutzbaren Programmbestandteilen\n"
        + "ebenfalls angezeigt werden.\n"
        + "\n"
        + "(3) Sie dürfen die Nutzung des Programms nicht von Pflichten oder Bedingungen ab"
        + "hängig machen, die nicht in dieser Lizenz vorgesehen sind.\n"
        + "\n"
        + "(4) Sofern Sie mit dem Programm eine Dokumentation erhalten haben, muss diese Do"
        + "kumentation entsprechend mitgeliefert werden, es sei denn, die freie Mitlieferun"
        + "g der Dokumentation ist Ihnen aufgrund der Lizenz für die Dokumentation nicht ge"
        + "stattet.\n"
        + "\n"
        + "§ 3 Weitere Pflichten beim Vertrieb veränderter Versionen\n"
        + "\n"
        + "(1) Veränderte Versionen des Programms dürfen Sie nur unter den Bedingungen dies"
        + "er Lizenz verbreiten oder öffentlich zugänglich machen, so dass Dritte das verän"
        + "derte Programm insgesamt unter dieser Lizenz nutzen können.\n"
        + "\n"
        + "(2) Wird das Programm oder ein Teil hiervon mit einem anderen Programm kombinier"
        + "t, gilt auch die Kombination insgesamt als eine veränderte Version des Programms"
        + ", es sei denn, das andere Programm ist formal und inhaltlich eigenständig. Ein a"
        + "nderes Programm ist dann als eigenständig anzusehen, wenn es die folgenden Vorau"
        + "ssetzungen alle erfüllt:\n"
        + "1. Der Source Code der kombinierten Programme muss jeweils in eigenen Dateien vo"
        + "rhanden sein, die keine Bestandteile des anderen Teils enthalten, die über die z"
        + "ur Programmkombination üblichen und erforderlichen Informationen über den andere"
        + "n Teil hinausgehen, wobei der Source Code des anderen Programms nicht mitgeliefe"
        + "rt werden muss.\n"
        + "2. Der mit dem Programm kombinierte Teil muss auch dann sinnvoll nutzbar sein, w"
        + "enn er nicht mit dem Programm kombiniert wird, und zwar entweder alleine oder mi"
        + "t sonstigen Programmen. Was als \"sinnvoll nutzbar\" anzusehen ist, richtet sich n"
        + "ach der Auffassung der betroffenen Fachkreise. Zu den betroffenen Fachkreisen ge"
        + "hören alle Personen, die das Programm oder Programme mit vergleichbarer Funktion"
        + "alität entwickeln, benutzen, verbreiten oder öffentlich zugänglich machen.\n"
        + "\n"
        + "(3) Wenn Sie das Programm oder einen Teil hiervon - verändert oder unverändert -"
        + " zusammen mit einem anderen Programm verbreiten oder öffentlich zugänglich mache"
        + "n, das unter der GNU General Public License (GPL) lizenziert wird, darf das Prog"
        + "ramm auch unter den Bedingungen der GPL genutzt werden, sofern es mit dem andere"
        + "n Programm ein \"derivative work\" im Sinne der GPL bildet. Dabei sollen die Hinwe"
        + "ise auf diese Lizenz entfernt und durch einen Hinweis auf die GPL ersetzt werden"
        + ". Ob bei der Zusammenstellung ein \"derivate work\" im Sinne der GPL entsteht, beu"
        + "rteilt sich nach Ziffer 2 b) der GPL. Diese Bestimmung lautet: \"You must cause a"
        + "ny work that you distribute or publish, that in whole or in part contains or is "
        + "derived from the Program or any part thereof, to be licensed as a whole at no ch"
        + "arge to all third parties under the terms of this License.\" Die GPL kann abgeruf"
        + "en werden unter http://www.fsf.org/licenses/gpl.\n"
        + "\n"
        + "(4) Wenn Sie das Programm in einer veränderten Form verbreiten oder öffentlich z"
        + "ugänglich machen, müssen Sie im Source Code einen Hinweis mit den Änderungen auf"
        + "nehmen und mit dem Datum der Änderung versehen. Der Hinweis muss erkennen lassen"
        + ", welche Änderungen vorgenommen wurden und bestehende Vermerke, die über die Urh"
        + "eber des Programms Auskunft geben, übernehmen. Dies gilt unabhängig davon, ob Si"
        + "e einen eigenen Urhebervermerk hinzufügen. Anstelle eines Hinweises im Source Co"
        + "de können Sie auch ein Versionskontrollsystem verwenden oder weiterführen, sofer"
        + "n dieses mitverbreitet wird oder öffentlich zugänglich ist.\n"
        + "\n"
        + "(5) Sie dürfen von Dritten für die Einräumung eines einfachen Nutzungsrechts an "
        + "veränderten Versionen des Programms kein Entgelt verlangen.\n"
        + "\n"
        + "(6) Wenn Sie an der veränderten Version des Programms ein anderes Schutzrecht al"
        + "s ein Urheberrecht erwerben, insbesondere ein Patent oder Gebrauchsmuster, lizen"
        + "zieren Sie dieses Schutzrecht für veränderte und unveränderte Versionen des Prog"
        + "ramms in dem Umfang, der erforderlich ist, um die Rechte aus dieser Lizenz wahrn"
        + "ehmen zu können.\n"
        + "\n"
        + "§ 4 Weitere Pflichten beim Vertrieb im Object Code\n"
        + "\n"
        + "(1) Wenn Sie das Programm nur im Object Code verbreiten, dann müssen Sie zusätzl"
        + "ich zu den in § 2 und § 3 geregelten Pflichten entweder\n"
        + "1. den vollständigen Source Code im Internet öffentlich zugänglich machen und be"
        + "i der Verbreitung des Object Codes deutlich auf die vollständige Internetadresse"
        + " hinweisen, unter der der Source Code abgerufen werden kann oder\n"
        + "2. den vollständigen Source Code auf einem hierfür üblichen Datenträger unter Be"
        + "achtung der §§ 2 und 3 mitverbreiten.\n"
        + "\n"
        + "(2) Wenn Sie das Programm im Object Code öffentlich zugänglich machen, dann müss"
        + "en Sie zusätzlich zu den in § 2 und § 3 geregelten Pflichten den vollständigen S"
        + "ource Code im Internet öffentlich zugänglich machen und dabei deutlich auf die v"
        + "ollständige Internetadresse hinweisen.\n"
        + "\n"
        + "(3) Sofern Sie mit dem Programm eine Dokumentation erhalten haben, muss diese Do"
        + "kumentation entsprechend der Absätze 1 und 2 mitgeliefert werden, es sei denn, d"
        + "ie freie Mitlieferung der Dokumentation ist Ihnen aufgrund der Lizenz für die Do"
        + "kumentation nicht gestattet.\n"
        + "\n"
        + "§ 5 Vertragsschluss\n"
        + "\n"
        + "(1) Mit dieser Lizenz wird Ihnen und jeder anderen Person ein Angebot auf Abschl"
        + "uss eines Vertrages über die Nutzung des Programms unter den Bedingungen der Deu"
        + "tschen Freien Softwarelizenz unterbreitet.\n"
        + "\n"
        + "(2) Sie dürfen das Programm nach den jeweils anwendbaren gesetzlichen Vorschrift"
        + "en bestimmungsgemäß benutzen, ohne dass es der Annahme dieser Lizenz bedarf. Die"
        + "ses Recht umfasst in der Europäischen Union und in den meisten anderen Rechtsord"
        + "nungen insbesondere die folgenden Befugnisse:\n"
        + "1. das Programm ablaufen zu lassen sowie die Erstellung von hierfür erforderlich"
        + "en Vervielfältigungen im Haupt- und Arbeitsspeicher;\n"
        + "2. das Erstellen einer Sicherungskopie;\n"
        + "3. die Fehlerberichtigung;\n"
        + "4. die Weitergabe einer rechtmäßig erworbenen körperlichen Kopie des Programms.\n"
        + "\n"
        + "(3) Sie erklären Ihre Zustimmung zum Abschluss dieser Lizenz, indem Sie das Prog"
        + "ramm verbreiten, öffentlich zugänglich machen, verändern oder in einer Weise ver"
        + "vielfältigen, die über die bestimmungsgemäße Nutzung im Sinne von Absatz 2 hinau"
        + "sgeht. Ab diesem Zeitpunkt ist diese Lizenz als rechtlich verbindlicher Vertrag "
        + "zwischen den Rechtsinhabern und Ihnen geschlossen, ohne dass es eines Zugangs de"
        + "r Annahmeerklärung bei den Rechtsinhabern bedarf.\n"
        + "\n"
        + "(4) Sie und jeder andere Lizenznehmer erhalten die Rechte aus dieser Lizenz dire"
        + "kt von den Rechtsinhabern. Eine Unterlizenzierung oder Übertragung der Rechte is"
        + "t nicht gestattet.\n"
        + "\n"
        + "§ 6 Beendigung der Rechte bei Zuwiderhandlung\n"
        + "\n"
        + "(1) Jede Verletzung Ihrer Verpflichtungen aus dieser Lizenz führt zu einer autom"
        + "atischen Beendigung Ihrer Rechte aus dieser Lizenz.\n"
        + "\n"
        + "(2) Die Rechte Dritter, die das Programm oder Rechte an dem Programm von Ihnen e"
        + "rhalten haben, bleiben hiervon unberührt.\n"
        + "\n"
        + "§ 7 Haftung und Gewährleistung\n"
        + "\n"
        + "(1) Für entgegenstehende Rechte Dritter haften die Rechtsinhaber nur, sofern sie"
        + " Kenntnis von diesen Rechten hatten, ohne Sie zu informieren.\n"
        + "\n"
        + "(2) Die Haftung für Fehler und sonstige Mängel des Programms richtet sich nach d"
        + "en außerhalb dieser Lizenz getroffenen Vereinbarungen zwischen Ihnen und den Rec"
        + "htsinhabern oder, wenn eine solche Vereinbarung nicht existiert, nach den gesetz"
        + "lichen Regelungen.\n"
        + "\n"
        + "§ 8 Verträge mit Dritten\n"
        + "\n"
        + "(1) Diese Lizenz regelt nur die Beziehung zwischen Ihnen und den Rechtsinhabern."
        + " Sie ist nicht Bestandteil der Verträge zwischen Ihnen und Dritten.\n"
        + "\n"
        + "(2) Die Lizenz beschränkt Sie nicht in der Freiheit, mit Dritten, die von Ihnen "
        + "Kopien des Programms erhalten oder Leistungen in Anspruch nehmen, die im Zusamme"
        + "nhang mit dem Programm stehen, Verträge beliebigen Inhalts zu schließen, sofern "
        + "Sie dabei Ihren Verpflichtungen aus dieser Lizenz nachkommen und die Rechte der "
        + "Dritten aus dieser Lizenz nicht beeinträchtigt werden. Insbesondere dürfen Sie f"
        + "ür die Überlassung des Programms oder sonstige Leistungen ein Entgelt verlangen.\n"
        + "\n"
        + "(3) Diese Lizenz verpflichtet Sie nicht, das Programm an Dritte weiterzugeben. E"
        + "s steht Ihnen frei zu entscheiden, wem Sie das Programm zugänglich machen. Sie d"
        + "ürfen aber die weitere Nutzung durch Dritte nicht durch den Einsatz technischer "
        + "Schutzmaßnahmen, insbesondere durch den Einsatz von Kopierschutzvorrichtungen je"
        + "glicher Art, verhindern oder erschweren. Eine passwortgeschützte Zugangsbeschrän"
        + "kung oder die Nutzung in einem Intranet wird nicht als technische Schutzmaßnahme"
        + " angesehen.\n"
        + "\n"
        + "§ 9 Text der Lizenz\n"
        + "\n"
        + "(1) Diese Lizenz ist in deutscher und englischer Sprache abgefasst. Beide Fassun"
        + "gen sind gleich verbindlich. Es wird unterstellt, dass die in der Lizenz verwand"
        + "ten Begriffe in beiden Fassungen dieselbe Bedeutung haben. Ergeben sich dennoch "
        + "Unterschiede, so ist die Bedeutung maßgeblich, welche die Fassungen unter Berück"
        + "sichtigung des Ziels und Zwecks der Lizenz am besten miteinander in Einklang bri"
        + "ngt.\n"
        + "\n"
        + "(2) Der Lizenzrat der Deutschen Freien Software Lizenz kann mit verbindlicher Wi"
        + "rkung neue Versionen der Lizenz in Kraft setzen, soweit dies erforderlich und zu"
        + "mutbar ist. Neue Versionen der Lizenz werden auf der Internetseite http://www.d-"
        + "fsl.de mit einer eindeutigen Versionsnummer veröffentlicht. Die neue Version der"
        + " Lizenz erlangt für Sie verbindliche Wirkung, wenn Sie von deren Veröffentlichun"
        + "g Kenntnis genommen haben. Gesetzliche Rechtsbehelfe gegen die Änderung der Lize"
        + "nz werden durch die vorstehenden Bestimmungen nicht beschränkt.\n"
        + "\n"
        + "(3) Sie dürfen diese Lizenz in unveränderter Form vervielfältigen, verbreiten un"
        + "d öffentlich zugänglich machen.\n"
        + "\n"
        + "§ 10 Anwendbares Recht\n"
        + "\n"
        + "Auf diese Lizenz findet deutsches Recht Anwendung.\n"
        + "\n"
        + "\n"
        + "Anhang: Wie unterstellen Sie ein Programm der Deutschen Freien Software Lizenz?\n"
        + "Um jedermann den Abschluss dieser Lizenz zu ermöglichen, wird empfohlen, das Pro"
        + "gramm mit folgendem Hinweis auf die Lizenz zu versehen:\n"
        + "\n"
        + "\"Copyright (C) 20[jj] [Name des Rechtsinhabers].\n"
        + "\n"
        + "Dieses Programm kann durch jedermann gemäß den Bestimmungen der Deutschen Freien"
        + " Software Lizenz genutzt werden.\n"
        + "\n"
        + "Die Lizenz kann unter http://www.d-fsl.de abgerufen werden.\"\n"
; // the license text
    }
 
    
}

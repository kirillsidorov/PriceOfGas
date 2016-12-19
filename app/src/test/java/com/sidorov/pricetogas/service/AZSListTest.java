package com.sidorov.pricetogas.service;

import com.sidorov.pricetogas.model.AZS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AZSListTest {
    AZSList azsList = new AZSList();
    String html = "\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
                "  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"ru\" lang=\"ru\" dir=\"ltr\">\n" +
                "  <head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<link rel=\"shortcut icon\" href=\"/sites/all/themes/rodnik/favicon.ico\" type=\"image/x-icon\" />\n" +
                "    <title>Сеть АГЗС | Газ пропан-бутан сжиженный, оптом и в розницу. Автомобильные газовые заправки (АГЗС, АГЗП и ГНС ), Харьков, Украина. Низкая цена</title>\n" +
                "    <meta name=\"Keywords\" content=\"газ пропан бутан заправки сжиженный цена АГЗС ГНС автомобильные газовые заправки адрес Харьков Украина газозаправочные станции газонаполнительная автозаправки продажа сеть баллон технический газовоз автоцистерны доставка поставка оптом оборудование родник\">    <link type=\"text/css\" rel=\"stylesheet\" media=\"all\" href=\"/css/css_b6d2d2a213996bac741cfd3f85457f1a.css\" />\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" media=\"print\" href=\"/css/css_d7751b95e048c7f4f4a138cfc8be3b33.css\" />\n" +
                "    <script type=\"text/javascript\" src=\"/js/js_ea00a011e3112ac12ddaeb70e2e53d98.js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "<!--//--><![CDATA[//><!--\n" +
                "jQuery.extend(Drupal.settings, { \"basePath\": \"/\" });\n" +
                "//--><!]]>\n" +
                "</script>\n" +
                "    <!--[if lt IE 7]>\n" +
                "      <link type=\"text/css\" rel=\"stylesheet\" media=\"all\" href=\"/sites/all/themes/rodnik/fix-ie.css\" />    <![endif]-->\n" +
                "<script type=\"text/javascript\">\n" +
                "\n" +
                "  var _gaq = _gaq || [];\n" +
                "  _gaq.push(['_setAccount', 'UA-18477685-1']);\n" +
                "  _gaq.push(['_trackPageview']);\n" +
                "\n" +
                "  (function() {\n" +
                "    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\n" +
                "    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n" +
                "    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\n" +
                "  })();\n" +
                "\n" +
                "</script>\n" +
                "  </head>\n" +
                "  <body class=\"sidebar-left\">\n" +
                "\n" +
                "<!-- Layout -->\n" +
                "\n" +
                "    <div id=\"wrapper\">\n" +
                "    <div id=\"container\" class=\"clear-block\">\n" +
                "\n" +
                "      <div id=\"header\">\n" +
                "\t\t\t          <div id=\"logo\">\n" +
                "        <a href=\"/\" title=\"\"></a>        </div>\n" +
                "\t\t\t\t<div id=\"truck\"></div>\n" +
                "\n" +
                "\n" +
                "      </div> <!-- /header -->\n" +
                "\n" +
                "        <div id=\"sidebar-left\" class=\"sidebar\">\n" +
                "                                      <ul class=\"links primary-links\"><li class=\"menu-318 first\"><a href=\"/\" title=\"Вернуться на главную страницу сайта\">Главная</a></li>\n" +
                "<li class=\"menu-1164\"><a href=\"/content/novosti\" title=\"\">Новости</a></li>\n" +
                "<li class=\"menu-748\"><a href=\"http://my.rodnik.ua/\" title=\"\">Личный кабинет</a></li>\n" +
                "<li class=\"menu-303 active-trail active\"><a href=\"/content/set-agzs\" title=\"Сеть АГЗС\" class=\"active\">Сеть АГЗС</a></li>\n" +
                "<li class=\"menu-322\"><a href=\"/content/smart-cards\" title=\"С 18.09.2008 вы можете стать владельцем смарт-карты «Род-Ник»!\">Смарт-карты</a></li>\n" +
                "<li class=\"menu-323\"><a href=\"/content/gasservice\" title=\"СТО &quot;Род-Ник&quot; - установка и сервис ГБО\">Сервис ГБО</a></li>\n" +
                "<li class=\"menu-377\"><a href=\"/content/cards-actions\" title=\"\">Акции</a></li>\n" +
                "<li class=\"menu-301\"><a href=\"/content/about\" title=\"О компании\">О компании</a></li>\n" +
                "<li class=\"menu-317\"><a href=\"/kontakty\" title=\"Связаться с нами\">Контакты</a></li>\n" +
                "<li class=\"menu-718\"><a href=\"/content/programma-loyalnosti-rod-nik-assistance\" title=\"Род-Ник Assistance\">Род-Ник Assistance</a></li>\n" +
                "<li class=\"menu-670 last\"><a href=\"/forum\" title=\"\">Форум</a></li>\n" +
                "</ul>                      <div id=\"block-views-gas_prices-block_2\" class=\"clear-block block block-views\">\n" +
                "\n" +
                "\n" +
                "  <div class=\"content\"><div class=\"view view-gas-prices view-id-gas_prices view-display-id-block_2 view-dom-id-1\">\n" +
                "    \n" +
                "  \n" +
                "  \n" +
                "      <div class=\"view-content\">\n" +
                "      <div class=\"item-list\">\n" +
                "    <ul>\n" +
                "          <li class=\"views-row views-row-1 views-row-odd views-row-first views-row-last\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "          <label class=\"views-label-field-gas-value\">\n" +
                "        ГАЗ:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">12.10</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "      </ul>\n" +
                "</div>    </div>\n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "</div> </div>\n" +
                "</div>\n" +
                "                            <ul class=\"links secondary-links\"><li class=\"menu-379 first\"><a href=\"/ru/faq/faq.htm\" title=\"\">Вопросы</a></li>\n" +
                "<li class=\"menu-596\"><a href=\"/sitemap\" title=\"\">Карта сайта</a></li>\n" +
                "<li class=\"menu-376 last\"><a href=\"/content/ssylki\" title=\"\">Ссылки</a></li>\n" +
                "</ul>                    </div>\n" +
                "\n" +
                "      <div id=\"center\"><div id=\"squeeze\">\n" +
                "\t\t\t\t<div id=\"stella_bott\"></div>\n" +
                "\t\t\t\t<div id=\"foot_bott\"></div>\n" +
                "\t\t\t\n" +
                "\t\t\t\t<div class=\"right-corner\">\n" +
                "\t\t\t\t\t<div id=\"cont_top\">\n" +
                "\t\t\t\t\t\t<div class=\"inner\"></div>\n" +
                "\t\t\t\t\t\t<div id=\"dec_left\"></div>\n" +
                "\t\t\t\t\t\t<div id=\"dec_right\"></div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t<div class=\"left-corner\">\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t<h2 class=\"title\">Сеть АГЗС</h2>\t\t\t\t\t<div class=\"tabs\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t                    \t\t\t\t\t<div id=\"node-3\" class=\"node\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <div class=\"content clear-block\">\n" +
                "    <p>Из-за роста численности транспортных средств давно замечена тенденция к увеличению доли розничной торговли. За последние 14 лет с 2002 по 2016 год компанией «Род-Ник» построены и реконструированы 13 автогазозаправочных (АГЗС) станций в харьковской области и на территории г.Харькова.</p>\n" +
                "<p>Сегодня все больше автомобилистов отдают предпочтение газовому топливу. Газовое оборудование на автомобили устанавливают не только службы такси, общественного транспорта, но и частные автовладельцы. Следовательно наша задача – обеспечить потенциальных потребителей удобными пунктами заправки автомобилей сжиженным углеводородным газом. Наши АГЗС обладают всеми необходимыми для этого предпосылками:</p>\n" +
                "<p><img alt=\"\" src=\"/sites/all/themes/rodnik/images/netgas11.jpg\" class=\"img_right\" /><br />\n" +
                "<img alt=\"\" src=\"/sites/all/themes/rodnik/images/netgas22.jpg\" class=\"img_right\" /></p>\n" +
                "<ul>\n" +
                "<li>удобное месторасположение;</li>\n" +
                "<li>организация движения на территории АГЗС;</li>\n" +
                "<li>количество заправочных колонок рассчитанное беспрепятственно производить заправку сразу нескольких автомобилей;</li>\n" +
                "<li>высокое качество газа, подтвержденное паспортом соответствия;</li>\n" +
                "<li>точный налив;</li>\n" +
                "<li>круглосуточное обслуживание;</li>\n" +
                "<li>квалифицированный персонал и соответствующая инфраструктура.</li>\n" +
                "</ul>\n" +
                "<p>Розничная продажа сжиженного газа пропан-бутан в сети автогазозаправочных станций АГЗС Род-Ник (Харьков, Украина). Основная цель каждого водителя – максимальный пробег на заправленном топливе без потери мощности. Эта цель осуществляется благодаря высококачественному газу, который предлагается на наших АГЗС.</p>\n" +
                "<p>На заправочных станциях «Род-Ник» установлено современное оборудование,которое как и  газовые электронные заправочные колонки объединено в единую систему, управляемую кассиром с помощью пульта управления или компьютерно-кассового аппарата. Такое управление дает возможность персоналу сосредоточиться на обслуживании конкретных клиентов,уделять им больше внимания и одновременно отслеживать работу всех колонок и технологического оборудования. С помощью единого цикла данной системы оформление кассовых чеков производится автоматически по завершении заправки на основании заданных кассиром данных.</p>\n" +
                "<p>Розничная торговля сжиженным газом на АГЗС осуществляется как за наличный расчет, так и по безналичному расчету. Наличие собственной базы хранения (ГНС) и парка газовозов позволяют обеспечить бесперебойную доставку газа в любое время и организовать стабильную работу сети автогазозаправочных станций.</p>\n" +
                "<h3>Список активных АГЗС компании \"Род-Ник\":</h3>\n" +
                "  </div>\n" +
                "\n" +
                "  <div class=\"clear-block\">\n" +
                "    <div class=\"meta\">\n" +
                "        </div>\n" +
                "\n" +
                "      </div>\n" +
                "\n" +
                "</div>\n" +
                "<div id=\"block-views-gas_prices-block_1\" class=\"clear-block block block-views\">\n" +
                "\n" +
                "\n" +
                "  <div class=\"content\"><div class=\"view view-gas-prices view-id-gas_prices view-display-id-block_1 view-dom-id-2\">\n" +
                "    \n" +
                "  \n" +
                "  \n" +
                "      <div class=\"view-content\">\n" +
                "      <div class=\"item-list\">\n" +
                "    <ul>\n" +
                "          <li class=\"views-row views-row-1 views-row-odd views-row-first\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.00</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-na-vezde-v-gzmiev\">АГЗС на въезде в г.Змиев</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">Харьковская область, Змиевской район, г.Змиев, ул.Харьковская,79</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(066) 720-55-89</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 8.00 до 8.15 и с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-2 views-row-even\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.00</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-pos-liman\">АГЗС в пос. Лиман</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">Харьковская область, Змиевской район, пос.Лиман, ул.Андреевская, 90</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(050) 561-61-49</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 7.00 до 7.15 и с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-3 views-row-odd\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">11.80</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-gkharkove-%E2%84%961\">АГЗС в г.Харькове №1</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">г.Харьков, ул. Биологическая, 6-й</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(057) 760-29-61</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 8.00 до 8.15 и с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-4 views-row-even\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.00</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-pos-bezlyudovka\">АГЗС в пос. Безлюдовка</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">Харьковская область ,Харьковский район,  ПГТ  Безлюдовка,  ул. Змиевская,1-д</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(095) 802-15-64</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 8.00 до 8.15 и с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-5 views-row-odd\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">11.80</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/node/20\">АГЗС в пос. Кулиничи</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">Харьковская область, Харьковский район, ПГТ Кулиничи, ул. Сиверская,186</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(095) 181-88-06</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">c 8.00 до 8.15 и с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-6 views-row-even\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.10</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-gkharkove-%E2%84%962\">АГЗС в г.Харькове №2</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">г.Харьков, Проспект 50-летия СССР, 241-б. (ул. Автострадная)</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(095) 651-29-71</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-7 views-row-odd\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.10</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-gkharkove-%E2%84%963\">АГЗС в г.Харькове №3</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">г.Харьков, проспект Гагарина, 316-ж (между автосалоном &quot;Mazda&quot; и с/м &quot;Новая Линия&quot;)</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(095) 302-30-38</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 8.00 до 8.15 и с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-8 views-row-even\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.10</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-gkharkove-%E2%84%964\">АГЗС в г.Харькове №4</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">г.Харьков, проспект Московский, 275-ж (пересечение с ул. Северной, район м. Масельского)</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(066) 209-51-43</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-9 views-row-odd\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">11.80</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-pos-solonitsevka\">АГЗС в пос. Солоницевка</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">Харьковская область, Дергачевский район, ПГТ Солоницевка, ул. Ленина, 131-а</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(099) 062-52-63</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 8.00 до 8.15 и с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-10 views-row-even\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.10</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-gkharkove-%E2%84%965\">АГЗС в г.Харькове №5</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">г.Харьков, ул. Блюхера, 4</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(095) 920-63-01</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-11 views-row-odd\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.10</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-gkharkove-%E2%84%966\">АГЗС в г.Харькове №6</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">г.Харьков, ул. Академика Павлова, 18-А (пересечение с Московским проспектом)</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(099) 617-03-71</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-12 views-row-even\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">11.90</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-gkharkove-%E2%84%967\">АГЗС в г.Харькове №7</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">г.Харьков, проспект Победы, 77-В (район круга трамвая)</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(099) 650-17-27</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "          <li class=\"views-row views-row-13 views-row-odd views-row-last\">  \n" +
                "  <div class=\"views-field-field-gas-value\">\n" +
                "                <span class=\"field-content\">12.00</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-title\">\n" +
                "                <span class=\"field-content\"><a href=\"/content/agzs-v-gkharkove-%E2%84%968\">АГЗС в г.Харькове №8</a></span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-address-value\">\n" +
                "          <label class=\"views-label-field-address-value\">\n" +
                "        Адрес:\n" +
                "      </label>\n" +
                "                <div class=\"field-content\">г. Харьков, ул. Гвардейцев-Широнинцев, перекресток с ул. Дружбы Народов</div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-phone-value\">\n" +
                "          <label class=\"views-label-field-phone-value\">\n" +
                "        Телефон:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">(050) 300-94-04</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-mode-value\">\n" +
                "          <label class=\"views-label-field-mode-value\">\n" +
                "        Режим работы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">Круглосуточно</span>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div class=\"views-field-field-breaks-value\">\n" +
                "          <label class=\"views-label-field-breaks-value\">\n" +
                "        Технологические перерывы:\n" +
                "      </label>\n" +
                "                <span class=\"field-content\">с 23.30 до 00.00</span>\n" +
                "  </div>\n" +
                "</li>\n" +
                "      </ul>\n" +
                "</div>    </div>\n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "</div> </div>\n" +
                "</div>\n" +
                "\t\t\t\t\t<div class=\"clear\"></div>\n" +
                "      </div> <!-- /.left-corner -->\n" +
                "\t\t\t<div id=\"footer\"><div class=\"inner\">\n" +
                "\t\t\t\t<div id=\"foot_right\"></div>\n" +
                "\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"links primary-links\"><li class=\"menu-318 first\"><a href=\"/\" title=\"Вернуться на главную страницу сайта\">Главная</a></li>\n" +
                "<li class=\"menu-1164\"><a href=\"/content/novosti\" title=\"\">Новости</a></li>\n" +
                "<li class=\"menu-748\"><a href=\"http://my.rodnik.ua/\" title=\"\">Личный кабинет</a></li>\n" +
                "<li class=\"menu-303 active-trail active\"><a href=\"/content/set-agzs\" title=\"Сеть АГЗС\" class=\"active\">Сеть АГЗС</a></li>\n" +
                "<li class=\"menu-322\"><a href=\"/content/smart-cards\" title=\"С 18.09.2008 вы можете стать владельцем смарт-карты «Род-Ник»!\">Смарт-карты</a></li>\n" +
                "<li class=\"menu-323\"><a href=\"/content/gasservice\" title=\"СТО &quot;Род-Ник&quot; - установка и сервис ГБО\">Сервис ГБО</a></li>\n" +
                "<li class=\"menu-377\"><a href=\"/content/cards-actions\" title=\"\">Акции</a></li>\n" +
                "<li class=\"menu-301\"><a href=\"/content/about\" title=\"О компании\">О компании</a></li>\n" +
                "<li class=\"menu-317\"><a href=\"/kontakty\" title=\"Связаться с нами\">Контакты</a></li>\n" +
                "<li class=\"menu-718\"><a href=\"/content/programma-loyalnosti-rod-nik-assistance\" title=\"Род-Ник Assistance\">Род-Ник Assistance</a></li>\n" +
                "<li class=\"menu-670 last\"><a href=\"/forum\" title=\"\">Форум</a></li>\n" +
                "</ul>\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t</div></div>\n" +
                "    </div></div></div> <!-- /.right-corner, /#squeeze, /#center -->\n" +
                "\n" +
                "      \n" +
                "    </div> <!-- /container -->\n" +
                "  </div>\n" +
                "<!-- /layout -->\n" +
                "\n" +
                "      <div class=\"counters\">\n" +
                "    <a href=\"http://www.yandex.ru/cy?base=0&amp;host=www.rod-nik.com.ua\" target=\"_blank\"><img src=\"http://www.yandex.ru/cycounter?www.rod-nik.com.ua\" width=\"88\" height=\"31\" border=\"0\"></a>\n" +
                "    <a href=\"http://top.mail.ru/jump?from=1347710\" target=\"_blank\"><img src=\"http://top.list.ru/counter?id=1347710;t=223\" width=\"88\" height=\"31\" border=\"0\"></a>\n" +
                "    <a href=\"http://top100.rambler.ru/top100/\" target=\"_blank\"><img src=\"http://counter.rambler.ru/top100.cnt?1269225\" width=\"88\" height=\"31\" border=\"0\"></a>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>\n";
        public org.jsoup.nodes.Document document = Jsoup.parse(html);


    @Test
    public void listInitSuccessfully() throws ExecutionException, InterruptedException {
        AZS azs = listInit(document).get(0);
        Assert.assertEquals(azs.getNAME(), "АГЗС на въезде в г.Змиев");
        Assert.assertEquals(azs.getTelephone(), "Телефон: (066) 720-55-89");
        Assert.assertEquals(azs.getAddress(), "Адрес: Харьковская область, Змиевской район, г.Змиев, ул.Харьковская,79");
        Assert.assertEquals(azs.getPRICE(), "12.00");
    }

    public ArrayList<AZS> listInit(org.jsoup.nodes.Document document){
        ArrayList<AZS> list = new ArrayList<>();
        Elements names = document.select(".views-field-title");
        Elements prices = document.select(".views-field-field-gas-value");
        Elements telephones = document.select(".views-field-field-phone-value");
        Elements adresses = document.select(".views-field-field-address-value");
        Elements modes = document.select(".views-field-field-mode-value");
        for (int i = 0; i < names.size(); i++) {
            Element name = names.get(i);
            Element price = prices.get(i+1);
            Element telephone = telephones.get(i);
            Element address = adresses.get(i);
            Element mode = modes.get(i);
            list.add(new AZS(
                    name.text(),
                    price.text(),
                    telephone.text(),
                    address.text(),
                    mode.text()
            ));
        }
        return list;
    }
}
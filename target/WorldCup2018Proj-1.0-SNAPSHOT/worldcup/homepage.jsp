<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <title>Homepage</title>
  <meta charset="UTF-8">
  <meta name="description" content="Описание">
  <meta name="author" content="Iskander Valiev">
  <!-- Стили -->
  <link rel="stylesheet" href="homepage/slick/slick.css">
  <link rel="stylesheet" href="homepage/slick/slick-theme.css">
  <link rel="stylesheet" href="/worldcup/homepage/style.css">
    <script type="text/javascript">
        function initializeTimer() {
            var endDate = new Date(2018,5,14); // получаем дату истечения таймера
            var currentDate = new Date(); // получаем текущую дату
            var seconds = (endDate-currentDate) / 1000; // определяем количество секунд до истечения таймера
            if (seconds > 0) {
                var minutes = seconds/60; // определяем количество минут до истечения таймера
                var hours = minutes/60; // определяем количество часов до истечения таймера
                var days = hours/24; //определяем количество дней до истечения таймера
                minutes = (hours - Math.floor(hours)) * 60; // подсчитываем кол-во оставшихся минут в текущем часе
                hours = (days - Math.floor(days)) * 24; // целое количество часов до истечения таймера
                hours = Math.floor(hours); //округляем до целого кол-ва оставшихся часов в текущем дне
                seconds = Math.floor((minutes - Math.floor(minutes)) * 60); // подсчитываем кол-во оставшихся секунд в текущей минуте
                minutes = Math.floor(minutes); // округляем до целого кол-во оставшихся минут в текущем часе
                days = Math.floor(days);
                setTimePage(days,hours,minutes,seconds); // выставляем начальные значения таймера

                function secOut() {
                    if (seconds == 0) { // если секунду закончились то
                        if (minutes == 0) { // если минуты закончились то
                            if (hours == 0) { // если часы закончились то
                                if (days == 0) {
                                    showMessage(timerId); // выводим сообщение об окончании отсчета
                                } else {
                                    days--; //уменьшаем кол-во дней
                                    hours = 23; //обновляем часы
                                    minutes = 59; //обновляем минуты
                                    seconds = 59; //обновляем секунды
                                }
                            } else {
                                hours--; // уменьшаем кол-во часов
                                minutes = 59; // обновляем минуты
                                seconds = 59; // обновляем секунды
                            }
                        } else {
                            minutes--; // уменьшаем кол-во минут
                            seconds = 59; // обновляем секунды
                        }
                    } else {
                        seconds--; // уменьшаем кол-во секунд
                    }
                    setTimePage(days,hours,minutes,seconds); // обновляем значения таймера на странице
                }
                timerId = setInterval(secOut, 1000) // устанавливаем вызов функции через каждую секунду
            } else {
                alert("Установленая дата уже прошла");
            }
        }

        function setTimePage(d,h,m,s) { // функция выставления таймера на странице
            var element = document.getElementById("timer"); // находим элемент с id = timer
            element.innerHTML = "Before World Cup 2018:<br>Days: " + d + " Hours:" + h + " Minutes:" + m + " Seconds:" + s; // выставляем новые значения таймеру на странице
        }

        function showMessage(timerId) { // функция, вызываемая по истчению времени
            alert("Time is left");
            clearInterval(timerId); // останавливаем вызов функции через каждую секунду
        }
    </script>
</head>

<body>
  <div class="main">
      <div id="header">
          <div id="menu">
              <ul class="menu">
                  <li><a href="/worldcup/homepage.jsp">Homepage</a></li>
                  <li><a href="/worldcup/matches.jsp">Matches</a>
                      <ul>
                          <li><a href="#">Group A</a></li>
                          <li><a href="#">Group B</a></li>
                          <li><a href="#">Group C</a></li>
                          <li><a href="#">Group D</a></li>
                          <li><a href="#">Group E</a></li>
                          <li><a href="#">Group F</a></li>
                          <li><a href="#">Group G</a></li>
                          <li><a href="#">Group H</a></li>
                      </ul>
                  </li>
                  <li><a href="/worldcup/cities.jsp">Cities</a>
                      <ul>
                          <li><a href="#">Kazan</a></li>
                          <li><a href="#">Moscow</a></li>
                          <li><a href="#">St. Petersburg</a></li>
                          <li><a href="#">Sochi</a></li>
                          <li><a href="#">Kaliningrad</a></li>
                          <li><a href="#">Saransk</a></li>
                          <li><a href="#">Nizhniy Novgorod</a></li>
                          <li><a href="#">Rostov-On-Don</a></li>
                          <li><a href="#">Volgograd</a></li>
                          <li><a href="#">Ekaterinburg</a></li>
                          <li><a href="#">Samara</a></li>
                      </ul>
                  </li>
                  <li><a href="#">Stadiums</a></li>
                  <li><a href="/teams">Teams</a></li>
                  <li><a href="/worldcup/galary.jsp">Galary</a></li>
                  <li><a href="/worldcup/contact.jsp">Contacts</a></li>
              </ul>
          </div>
          <%--<div id = "clockdiv">--%>
              <%--Before WC2018: <span class="days"></span><span class="hours"></span><span class="minutes"></span><span class="seconds"></span>--%>
          <%--</div>--%>
          <div id="profile-menu">
              <ul class="profile-menu">
                  <li><a href="/profile">Profile</a></li>
                  <li><a href="/exit">Exit</a></li>
              </ul>
          </div>
      </div>

      <hr>

      <div class="sl">
          <div class="sl_slide"><a href="#"><img src="homepage/images/spain.jpg" alt="slide 1" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">Spain secure Russia 2018 berth.</h3>
                  <p class="sl_desc">Spain secure qualification to next year’s World Cup.</p>
              </div>
          </a></div>
          <div class="sl_slide"><a href="#"><img src="homepage/images/germany.jpg" alt="slide 2" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">Germay finished top of World Cup qualifying Group C and qualified to Russia.</h3>
                  <p class="sl_desc">Defending champions Germany confirmed their qualification for next year's World Cup in Russia by beating Northern Ireland 3-1 in Belfast.</p>
              </div>
          </a></div>
          <div class="sl_slide"><a href="#"><img src="homepage/images/1.jpg" alt="slide 3" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">Slide 3</h3>
                  <p class="sl_desc">Description 3</p>
              </div>
          </a></div>
          <div class="sl_slide"><a href="#"><img src="homepage/images/england.jpg" alt="slide 4" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">England’s lions: the late show specialists.</h3>
                  <p class="sl_desc">England qualified for 2018 FIFA World Cup with victory against Slovenia.</p>
              </div>
          </a></div>
          <div class="sl_slide"><a href="#"><img src="homepage/images/sweden.jpg" alt="slide 5" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">France edge closer as Sweden, Belgium break records.</h3>
                  <p class="sl_desc">The latest European qualifiers ended without any fresh names added to the list of 2018 FIFA World Cup Russia™ participants.</p>
              </div>
          </a></div>
          <%--<c:forEach items="${lastnews}" var="${news}">--%>
              <%--<div class="sl_slide"><a href="#"><img src="${news.image}" alt="slide 5" class="sl_img">--%>
                  <%--<div class="sl_text">--%>
                      <%--<h3 class="sl_header">${news.header}</h3>--%>
                      <%--<p class="sl_desc">The latest European qualifiers ended without any fresh names added to the list of 2018 FIFA World Cup Russia™ participants.</p>--%>
                  <%--</div>--%>
              <%--</a></div>--%>
          <%--</c:forEach>--%>
          <!--TODO complete slides creating-->
      </div>

      <div class="information">
          <div class="block1">
              <a href="/news">
                  <img src="homepage/images/news.jpg" alt="news" class="info_img">
                  <div class="info_text">
                      <h3 class="info_header">News 1</h3>
                      <p class="info_desc">Description</p>
                  </div>
              </a>
          </div>
          <div class="block2">
              <a href="#">
                  <img src="homepage/images/kazan_block2.jpg" alt="kazan" class="long_info_img">
                  <div class="info_text">
                      <h3 class="info_header">News 2</h3>
                      <p class="info_desc">Description</p>
                  </div>
              </a>
          </div>
          <div class="block1">
              <a href="#">
                  <img src="homepage/images/restaurants.jpg" alt="restaurants" class="info_img">
                  <div class="info_text">
                      <h3 class="info_header">News 3</h3>
                      <p class="info_desc">Description</p>
                  </div>
              </a>
          </div>
          <div class="block3">
              <a href="#">
                  <img src="homepage/images/fans.jpg" alt="fan" class="info_img">
                  <div class="info_text">
                      <h3 class="info_header">Fan guide</h3>
                      <p class="info_desc">Everything you need to know about travelling to Russia and staying there to enjoy the World Cup</p>
                  </div>
              </a>
          </div>
          <div class="block1">
              <a href="#">
                  <img src="homepage/images/vol.jpg" alt="volunteers" class="info_img">
                  <div class="info_text">
                      <h3 class="info_header">Volunteer programme</h3>
                      <p class="info_desc">Everything you need to know aboun volunteering</p>
                  </div>
              </a>
          </div>
      </div>

      <div id="footer">
          <img src="">
      </div>
  </div>
  <!-- Конец кода -->
  <!-- Подключаем скрипты -->
  <script src = "<c:url value="http://yastatic.net/jquery/2.1.3/jquery.min.js"/>"></script>
  <script src="homepage/slick/slick.min.js"></script>
  <script src="homepage/js/js.js"></script>
</body>
</html>

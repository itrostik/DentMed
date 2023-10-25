<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>ДентМед</title>
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/forum.css">
</head>
<body>
<div class="wrapper">
    <#include "header.ftl">
  <main class="main __container">
    <div class="messages">
        <#if messages??>
            <#list users as elem>
                <#list messages as item>
                    <#if user??>
                        <#if elem.userId == item.userId>
                            <#if user.userId == item.userId>
                              <div class="message messageUser">
                                <form action="/deleteMessage" class="form__message">
                                  <input type="text" name="messageId" value="${item.messageId}" style="display: none">
                                  <input type="text" name="userId" value="${user.userId}"
                                         style="display: none">
                                  <button type="submit" class="message__delete">
                                    <img src="./img/multiplyWhite.svg" alt="">
                                  </button>
                                </form>
                                <div class="message__text">${item.messageText}</div>
                                <div class="message__info">
                                  <span>${elem.firstName + " " + elem.lastName}</span>
                                  <span>${item.messageDate}</span>
                                </div>
                                <div class="messageUser__image">
                                  <img src="./img/mymessagetriangle.svg" alt="">
                                </div>
                              </div>
                            <#else>
                              <div class="message">
                                <div class="message__text">${item.messageText}</div>
                                <div class="message__info">
                                  <span>${elem.firstName + " " + elem.lastName}</span>
                                  <span>${item.messageDate}</span>
                                </div>
                                <div class="message__image">
                                  <img src="./img/messagetriangle.svg" alt="">
                                </div>
                              </div>
                            </#if>
                        </#if>
                    <#else>
                        <#if elem.userId == item.userId>
                          <div class="message">
                            <div class="message__text">${item.messageText}</div>
                            <div class="message__info">
                              <span>${elem.firstName + " " + elem.lastName}</span>
                              <span>${item.messageDate}</span>
                            </div>
                            <div class="message__image">
                              <img src="./img/messagetriangle.svg" alt="">
                            </div>
                          </div>
                        </#if>
                    </#if>
                </#list>
            </#list>
        </#if>
    </div>
    <form action="/forum" method="post">
      <input type="text" name="message" class="message__input" placeholder="Напишите сообщение">
        <#if user??>
          <button type="submit" class="message__button">Написать cообщение</button>
        <#else>
          <a href="/login" class="message__button" style="color: #ffffff">Написать сообщение</a>
        </#if>
    </form>
  </main>
    <#include "footer.ftl">
</div>
<script src="js/main.js"></script>
<script src="js/forum.js"></script>
</body>
</html>
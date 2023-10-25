<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>ДентМед</title>
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/posts.css">
</head>
<body>
<div class="wrapper">
    <#include "header.ftl">
  <main class="main __container">
    <div class="posts">
      <div class="post">
        <div class="post__title">${post.title}</div>
        <div class="post__content">${post.content}</div>
        <div class="comments">
            <#if comments??>
                <#list users as elem>
                    <#list comments as item>
                        <#if elem.userId == item.userId>
                          <div class="comment">
                            <span class="comment__text">${item.commentText}</span>
                            <span>${elem.firstName + " " + elem.lastName}</span>
                            <span>${item.commentDate}</span>
                              <#if user??>
                                  <#if user.userId == item.userId>
                                    <form action="/deleteComment">
                                      <input type="text" name="postId" value="${post.postId}" style="display: none">
                                      <input type="text" name="commentId" value="${item.commentId}"
                                             style="display: none">
                                      <button type="submit" class="comment__delete">
                                        <img src="./img/multiply.svg" alt="">
                                      </button>
                                    </form>
                                  </#if>
                              </#if>
                          </div>
                        </#if>
                    </#list>
                </#list>
            </#if>
        </div>

        <form action="/post" method="post">
          <input type="text" name="postId" value="${post.postId}" style="display: none">
          <input type="text" name="comment" class="comment__input" placeholder="Напишите комментарий">
            <#if user??>
              <button type="submit" class="post__button">Написать комментарий</button>
            <#else>
              <a href="/login" class="post__button" style="color: #ffffff">Написать комментарий</a>
            </#if>
        </form>
        <div class="post__info">
          <div class="post__date">${post.date}</div>
        </div>
      </div>
    </div>
  </main>
    <#include "footer.ftl">
</div>
<script src="js/main.js"></script>
</body>
</html>
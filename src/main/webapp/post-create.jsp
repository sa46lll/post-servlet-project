<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
<style>
/* 전체 레이아웃 */
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

/* 입력 필드 레이아웃 */
.form-group {
  margin-bottom: 20px;
}

/* 라벨 스타일 */
label {
  display: block;
  margin-bottom: 5px;
}

/* 입력 필드 스타일 */
input[type=text], textarea {
  width: 100%;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

/* 버튼 스타일 */
.btn {
  display: inline-block;
  padding: 10px 20px;
  border-radius: 5px;
  background-color: #007bff;
  color: #fff;
  text-decoration: none;
  cursor: pointer;
}

.btn-cancel {
  background-color: #ccc;
}

/* 입력 필드 간격 조절 */
.form-group > * {
  margin-bottom: 10px;
}

/* 가운데 정렬 */
.text-center {
  text-align: center;
}
</style>
</head>
<body>
	<div class="container">
    <h1 class="text-center">게시물 작성</h1>
    <form method="POST" action="posts">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" id="title" name="title">
      </div>
      <div class="form-group">
        <label for="member-id">작성자</label>
        <input type="text" id="member-id" name="member-id" value="${ memberId }" disabled>
      </div>
      <div class="form-group">
        <label for="content">내용</label>
        <textarea id="content" name="content" rows="5"></textarea>
      </div>
      <div class="form-group">
        <label for="created-at">작성일</label>
        <input type="text" id="created-at" name="created-at" value="${ now }" disabled>
      </div>
      <div class="form-group text-center">
        <button type="submit" class="btn">저장</button>
        <a href="#" class="btn btn-cancel">취소</a>
      </div>
    </form>
  </div>
</body>
</html>
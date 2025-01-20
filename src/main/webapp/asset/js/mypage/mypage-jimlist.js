// 찜 아이콘 클릭 이벤트
function toggleLike(element, isLike) {
  const likeWrapper = element.parentElement;
  const likeIcon = likeWrapper.querySelector('.mypage-img-like');
  const noLikeIcon = likeWrapper.querySelector('.mypage-img-nolike');

  if (isLike) {
    // 'like' 클릭 시
    likeIcon.style.display = 'none';
    noLikeIcon.style.display = 'inline-block';
  } else {
    // 'no-like' 클릭 시
    noLikeIcon.style.display = 'none';
    likeIcon.style.display = 'inline-block';
  }
}
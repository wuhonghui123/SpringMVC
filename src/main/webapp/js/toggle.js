/* 找元素---找对象 */
const guetnews1 = document.getElementById("guetnews1");
const schoolnews1 = document.getElementById("schoolnews1");
const collegenews1 = document.getElementById("collegenews1");
const mediaguet1 = document.getElementById("mediaguet1");
const guetnews = document.getElementsByClassName("guetnews");
const schoolnews = document.getElementsByClassName("schoolnews");
const collegenews = document.getElementsByClassName("collegenews");
const mediaguet = document.getElementsByClassName("mediaguet");
/* 操作元素---搞对象  */
/* 鼠标一上去之后 */
guetnews1.onmouseover = function (){
    guetnews.style.display="block";
    schoolnews.style.display="none";
    collegenews.style.display="none";
    mediaguet.style.display="none";
}
schoolnews1.onmouseover = function () {
    guetnews.style.display="none";
    schoolnews.style.display="block";
    collegenews.style.display="none";
    mediaguet.style.display="none";
}
collegenews1.onmouseover = function () {
    guetnews.style.display="none";
    schoolnews.style.display="block";
    collegenews.style.display="none";
    mediaguet.style.display="none";
}
mediaguet1.onmouseover = function () {
    guetnews.style.display="none";
    schoolnews.style.display="block";
    collegenews.style.display="none";
    mediaguet.style.display="none";
}
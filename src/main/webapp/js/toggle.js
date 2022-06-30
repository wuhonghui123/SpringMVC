function guetnews(){
    document.getElementById("guetnews").style.display = 'list-item';
    document.getElementById("schoolnews").style.display = 'none';
    document.getElementById("collegenews").style.display = 'none';
    document.getElementById("mediaguet").style.display = 'none';
}
function schoolnews(){
    document.getElementById("guetnews").style.display = 'none';
    document.getElementById("schoolnews").style.display = 'list-item';
    document.getElementById("collegenews").style.display = 'none';
    document.getElementById("mediaguet").style.display = 'none';
}
function collegenews(){
    document.getElementById("guetnews").style.display = 'none';
    document.getElementById("schoolnews").style.display = 'none';
    document.getElementById("collegenews").style.display = 'list-item';
    document.getElementById("mediaguet").style.display = 'none';
}
function mediaguet(){
    document.getElementById("guetnews").style.display = 'none';
    document.getElementById("schoolnews").style.display = 'none';
    document.getElementById("collegenews").style.display = 'none';
    document.getElementById("mediaguet").style.display = 'list-item';
}
function category_8(){
    document.getElementById("category_8").style.display = 'list-item';
    document.getElementById("category_10").style.display = 'none';
}
function category_10(){
    document.getElementById("category_8").style.display = 'none';
    document.getElementById("category_10").style.display = 'list-item';
}
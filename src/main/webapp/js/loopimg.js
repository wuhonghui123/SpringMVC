window.onload = () => {
    let list = document.getElementById('list');
    let ol = document.getElementsByTagName('ol')[0];
    let display = document.getElementById('display');
    let currentIndex = 0;
    let autoPlay = () => {
        window.autoPlay = true;
        window.autoPlayTimer = setInterval(() => move((currentIndex + 1) % 5), 5000);
    }
    let stopPlay = () => {
        if (window.autoPlay) {
            window.autoPlay = false;
            clearInterval(window.autoPlayTimer);
        }
    }
    //创建索引按钮
    for (let i = 0; i < 5; i++) {
        let li = document.createElement('li');
        li.className = 'index';
        if (i === 0) li.className += ' current';
        li.index = i;
        ol.appendChild(li);
        li.addEventListener('mouseover', function() {
            move(this.index);
            stopPlay();
        });
    }
    let arrow = document.getElementById('arrow');
    let showArrow = () => arrow.style.display = 'block';
    let hideArrow = () => arrow.style.display = 'none';
    //核心move函数
    let move = (index) => {
        let width = display.offsetWidth;
        for (let i = 0; i < 5; i++) {
            //改变当前索引按钮
            if ((index % 5) === i) {
                ol.children[i].className = 'index current';
            } else ol.children[i].className = 'index';
        }
        //移动lists
        list.style.left = (-index) * width + 'px';
        currentIndex = index;
    }
    display.addEventListener('mouseover', showArrow)
    display.addEventListener('mouseleave', () => {
        hideArrow();
        if (!window.autoPlay) {
            //重新开始自动播放
            autoPlay();
        }
    })

    let left = document.getElementById('left');
    let right = document.getElementById('right');
    left.addEventListener('click', () => {
        move((currentIndex - 1) === -1 ? 4 : currentIndex - 1);
        stopPlay();
    });
    right.addEventListener('click', () => {
        move((currentIndex + 1) % 5);
        stopPlay();
    });

    //启动自动播放
    move(0);
    autoPlay();
}
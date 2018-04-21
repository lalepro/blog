var mug = document.querySelector('.img1');
var angle = 0, lastTime = null;
function animate(time){
    if (lastTime != null)
        angle += (time - lastTime) * 0.0007;
    lastTime = time;
    mug.style.top = (Math.sin(angle) * 300) + "px";
    mug.style.right = (Math.cos(angle) * 300) + "px";
    requestAnimationFrame(animate);
}
requestAnimationFrame(animate);
function LinkSideBar({ isActive, href, aria_current}: any){

    return(
        <>
            <a href={href} className={`nav-link ${isActive}`} aria-current={aria_current}></a>
        </>
    )

}

export default LinkSideBar;
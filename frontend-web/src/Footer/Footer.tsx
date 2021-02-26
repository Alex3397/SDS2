import "./Footer.css"
import { ReactComponent as InstagramIcon } from './instagram.svg'
import { ReactComponent as LinkedinIcon } from './linkedin.svg'
import { ReactComponent as YoutubeIcon } from './youtube.svg'


function Footer() {
    return (
        <>
      <footer className="main-footer">
          App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
          <div className="footer-icons">
            <a target="_new" href="https://www.youtube.com/">
                <YoutubeIcon />
            </a>
            <a target="_new" href="https://www.linkedin.com/feed/">
                <LinkedinIcon />
            </a>
            <a target="_new" href="https://www.instagram.com/">
                <InstagramIcon />
            </a>
          </div>
      </footer>
      </>
    )
  }
  
  export default Footer;
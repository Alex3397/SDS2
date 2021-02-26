import { Link } from 'react-router-dom';
import Footer from '../Footer/Footer';
import './Home.css';
import { ReactComponent as Image } from './main.svg'

function Home() {
    return(
        <>
        <div className="home-container">
            <div className="home-content">
                <div className="home-actions">
                    <h1 className="home-tittle">
                        Faça seu pedido <br /> que entregamos <br /> para você!!!
                    </h1>
                    <h3>
                        Escolha o seu pedido e em poucos minutos <br /> levaremos até a sua porta
                    </h3>
                    <Link className="home-btn-order" to="/orders">
                        FAZER PEDIDO
                    </Link>
                </div>
                <div className="home-image">
                    <Image />
                </div>
            </div>
        </div>
        <Footer />
        </>
    )
}

export default Home;
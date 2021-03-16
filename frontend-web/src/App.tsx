import React from 'react';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './App.css';
import { Helmet } from 'react-helmet';
import Routes from './Routes';

function App() {
  return (
    <>
      <Helmet>
        <title>Made by: Alex3397</title>
      </Helmet>
      <Routes />
      <ToastContainer />
    </>
  );
}

export default App;

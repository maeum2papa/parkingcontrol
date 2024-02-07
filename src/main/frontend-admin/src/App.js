import logo from './logo.svg';
import './App.css';

import React,{useEffect,useState} from 'react';
import axios from 'axios';

function App() {

  const [data,setData] = useState("");

  useEffect(()=>{
    axios.post("http://localhost:20000/api/v1/calculate",{
      "IOTYPE": "C",
      "sitenum": 1,
      "groupnum": 1,
      "devicenum": 402,
      "carnum": "808너1303"
    })
    .then(res => {
      console.log(res.data);
      setData(JSON.stringify(res.data));
    })
    .catch(error => console.log(error));
  },[]);



  return (
    <div className="App">
      <div>받아온 값 : {data}</div>
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;

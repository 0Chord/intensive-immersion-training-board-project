import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Board from "./pages/Board";
import Write from "./pages/Write";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <Routes>
              <Route path={"/"} element={<Home/>}/>
              <Route path={"/board/:id"} element={<Board/>}/>
              <Route path={"/write-board"} element={<Write/>}/>
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

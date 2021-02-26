import { useState } from "react";

function Counter() {
    const [counter, setCounter] = useState(0);
    const handleIncrease = () => {
        setCounter(counter + 1)
    }
    const handleDecrease = () => {
        setCounter(counter - 1)
    }
    return (
        <div>
            <button onClick={handleIncrease}>Aumentar</button>
            <button onClick={handleDecrease}>Diminuir</button>
            <h1>Contador: {counter}</h1>
        </div>
    )
}

export default Counter;
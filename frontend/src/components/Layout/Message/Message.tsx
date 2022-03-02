import { useState, useEffect } from 'react';
import "./styles.css";

function Message( {type, msg, }: any ){

    const [visible, setVisible] = useState(false);

    useEffect(() => {

        if(!msg){
            setVisible(false);
            return
        }

        setVisible(true);
        const timer = setTimeout(() => {
            setVisible(false);
        }, 30000);

        return () => clearTimeout(timer);

    },[msg]);

    return(
        <>
            {visible && (
                <div className={`message ${type}`}>{msg}</div>
            )}
        </>
    );
}

export default Message;
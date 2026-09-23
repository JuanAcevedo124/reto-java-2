// LECCIÓN 08: PATRÓN ADAPTER
// Archivo: 08-Adapter.java

// ¿QUÉ ES?
// Adapter convierte la interfaz de una clase en otra que el cliente espera.
// Permite que clases incompatibles trabajen juntas.

// ¿CUÁNDO SE USA?
// - Conectar código viejo con código nuevo
// - Usar librerías externas con interfaces diferentes
// - Conectar sistemas que hablan "idiomas" diferentes

// ==================== EJEMPLO SENCILLO ====================

// Interfaz que el cliente espera
interface MediaPlayer {
    void play(String archivo);
}

// Clase incompatible (solo reproduce MP3)
class MP3Player {
    void playMP3(String archivo) {
        System.out.println("🎵 Reproduciendo MP3: " + archivo);
    }
}

// Adapter: convierte MediaPlayer a MP3Player
class MP3Adapter implements MediaPlayer {
    private MP3Player mp3Player;

    public MP3Adapter() {
        this.mp3Player = new MP3Player();
    }

    public void play(String archivo) {
        mp3Player.playMP3(archivo);
    }
}

// Otra clase incompatible
class VLCPlayer {
    void playVLC(String archivo, String formato) {
        System.out.println("🎬 VLC reproduce " + formato + ": " + archivo);
    }
}

// Adapter para VLC
class VLCAdapter implements MediaPlayer {
    private VLCPlayer vlcPlayer;

    public VLCAdapter() {
        this.vlcPlayer = new VLCPlayer();
    }

    public void play(String archivo) {
        String formato = archivo.substring(archivo.lastIndexOf(".") + 1);
        vlcPlayer.playVLC(archivo, formato);
    }
}

// ==================== EJEMPLO PRÁCTICO ====================

// Interfaz moderna
interface Observador {
    void onEvento(String tipo, String datos);
}

// Sistema viejo con interfaz diferente
class Sensor viejo {
    void detectarCambio(String valor) {
        System.out.println("📡 Sensor detectó: " + valor);
    }
}

class SensorAdapter implements Observador {
    private SensorViejo sensor;

    public SensorAdapter(SensorViejo sensor) {
        this.sensor = sensor;
    }

    public void onEvento(String tipo, String datos) {
        sensor.detectarCambio(tipo + ": " + datos);
    }
}

// ==================== CLASE PRINCIPAL ====================

public class Adapter {
    public static void main(String[] args) {

        System.out.println("=== ADAPTER ===\n");

        // Ejemplo 1: Reproductores
        System.out.println("--- Reproductores de Música ---");

        MediaPlayer mp3 = new MP3Adapter();
        MediaPlayer vlc = new VLCAdapter();

        mp3.play("cancion.mp3");
        vlc.play("pelicula.mp4");
        vlc.play("video.avi");

        // Ejemplo práctico: Adaptador de temperatura
        System.out.println("\n--- Sensor de Temperatura ---");

        SensorViejo sensorViejo = new SensorViejo();
        Observador adapter = new SensorAdapter(sensorViejo);

        adapter.onEvento("temperatura", "25°C");
        adapter.onEvento("humedad", "60%");
    }
}

// RESUMEN:
// 1. Interfaz esperada → lo que el cliente quiere usar
// 2. Clase incompatible → la que ya existe y no puedes cambiar
// 3. Adapter → implementa la interfaz esperada, usa la clase vieja por dentro
// 4. Ventaja: usas código viejo sin modificarlo

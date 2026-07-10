# QuickShutdown

Minimal Android app to shut down your phone with a single tap. No floating icons. No bloat.

## Requirements

- Android 5.0+ (API 21)
- **Root access** — shutdown requires root (`su`)

## How it works

Tap the power button → confirm → phone shuts down via `su -c reboot -p`.

## Build

Open in Android Studio and run, or:

```bash
./gradlew assembleRelease
```

## Why root?

Android does not expose a public API for shutdown to third-party apps. Root is the only clean way to do it without accessibility overlays or floating icons.
